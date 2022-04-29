package kr.co.photograph.jhgallery.service.photoservice;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import kr.co.photograph.jhgallery.component.Flickr;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.model.MyPhoto;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Getter
@Service
@RequiredArgsConstructor
public class PhotoServiceAdmin implements PhotoService {

    private final Flickr flickr;
    private final PhotoRepository photoRepository;


    @Override
    public void searchToMyPhoto() throws FlickrException {
        String flag;
        PhotoList<Photo> searchedPhotoList = searchByUserId();
        for (Photo photo : searchedPhotoList) {
            if (photo.isPublicFlag()) {
                flag = Flag.PUBLIC.toString();
            } else {
                flag = Flag.PRIVATE.toString();
            }
            photoRepository.save(new MyPhoto(
                    photo.getId(),
                    photo.getLargeUrl(),
                    photo.getMediumUrl(),
                    photo.getTitle(),
                    flag
            ));
        }
    }

    @Override
    public PhotoList<Photo> searchByUserId() throws FlickrException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setUserId(flickr.getUserId());

        PhotoList<Photo> photoList = flickr.getFlickr().getPhotosInterface().search(searchParameters, 500, 0);
        return photoList;
    }

    @Override
    public void refreshPhotoList() throws FlickrException {
        photoRepository.clear();
        searchToMyPhoto();
    }
}
