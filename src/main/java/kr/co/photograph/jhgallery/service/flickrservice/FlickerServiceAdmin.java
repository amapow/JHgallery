package kr.co.photograph.jhgallery.service.flickrservice;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.photos.Permissions;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import kr.co.photograph.jhgallery.component.Flickr;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.model.MyPhoto;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import kr.co.photograph.jhgallery.service.authservice.FlickrAuthService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class FlickerServiceAdmin implements FlickrService {
    private final Flickr flickr;
    private final FlickrAuthService flickrAuthService;

    @Override
    public void upload(String fileName, String title, String flag) throws FlickrException{
        log.info("filename = {}", fileName);
        File file = new File(fileName);
        Uploader uploader = flickr.getFlickr().getUploader();
        RequestContext.getRequestContext().setAuth(flickrAuthService.getAuth());
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);
        if (flag.equals("PUBLIC")) {
            uploadMetaData.setPublicFlag(true);
        } else {
            uploadMetaData.setHidden(true);
        }
        uploader.upload(file, uploadMetaData);
    }

    @Override
    public void delete(ArrayList<String> deleteItem) throws FlickrException {
        RequestContext.getRequestContext().setAuth(flickrAuthService.getAuth());
        for (String item : deleteItem) {
            flickr.getFlickr().getPhotosInterface().delete(item);
        }
    }

    @Override
    public void config(MyPhoto myPhoto, String title, String flag, Map<Integer, MyPhoto> photoStore) throws FlickrException {
        Permissions permFlag = new Permissions();
        if (flag.equals(Flag.PUBLIC.toString())) {
            permFlag.setPublicFlag(true);
        } else {
            permFlag.setFamilyFlag(true);
        }
        RequestContext.getRequestContext().setAuth(flickrAuthService.getAuth());
        if (!myPhoto.getTitle().equals(title) || !myPhoto.getFlag().equals(flag)) {
            log.info("title={}", title);
            log.info("photo title={}", myPhoto.getTitle());
            log.info("flag={}", flag);
            log.info("myPhoto = {}", myPhoto);
            log.info("photoStore size = {}", photoStore.size());
            log.info("title config found = {}", myPhoto.getMediumUrl());
            flickr.getFlickr().getPhotosInterface().setMeta(myPhoto.getId(), title, "");
            flickr.getFlickr().getPhotosInterface().setPerms(myPhoto.getId(), permFlag);
        }


    }
}
