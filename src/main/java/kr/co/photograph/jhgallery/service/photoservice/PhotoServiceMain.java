package kr.co.photograph.jhgallery.service.photoservice;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import kr.co.photograph.jhgallery.component.Flickr;
import kr.co.photograph.jhgallery.model.MyPhoto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Getter
@Service
@RequiredArgsConstructor
public class PhotoServiceMain implements PhotoService {

    private final Flickr flickr;
    private ArrayList<MyPhoto> myPhotoList = new ArrayList<>();

    @PostConstruct
    void init() throws FlickrException {
        this.myPhotoList = searchToMyPhoto();
    }

    @Override
    public ArrayList<MyPhoto> searchToMyPhoto() throws FlickrException {
        int index = 0;
        PhotoList<Photo> searchedPhotoList = searchByUserId();
        for (Photo photo : searchedPhotoList) {
            myPhotoList.add(index, new MyPhoto(
                    photo.getId(),
                    photo.getLargeUrl(),
                    photo.getMediumUrl(),
                    photo.getTitle(),
                    index));
            index++;
        }
        return myPhotoList;
    }

    @Override
    public PhotoList<Photo> searchByUserId() throws FlickrException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setUserId(flickr.getUserId());
        searchParameters.setPrivacyFilter(1);

        PhotoList<Photo> photoList = flickr.getFlickr().getPhotosInterface().search(searchParameters, 500, 0);
        return photoList;
    }

    @Override
    public void refreshPhotoList() throws FlickrException {
        myPhotoList.clear();
        this.myPhotoList = searchToMyPhoto();
    }
}
