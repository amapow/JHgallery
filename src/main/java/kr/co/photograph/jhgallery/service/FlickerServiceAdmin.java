package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import kr.co.photograph.jhgallery.component.Flickr;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Getter
@Service
@RequiredArgsConstructor
public class FlickerServiceAdmin implements FlickrService {
    private final Flickr flickr;
    private final FlickrAuthService flickrAuthService;

    @Override
    public void upload() throws FlickrException{
        File file = new File("/Users/janghyeon/Pictures/8a7ca600f906.jpeg");

        Uploader uploader = flickr.getFlickr().getUploader();
        RequestContext.getRequestContext().setAuth(flickrAuthService.getAuth());
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        uploadMetaData.setTitle("Photo upload Test");

        uploader.upload(file, uploadMetaData);
    }

    @Override
    public void delete(ArrayList<String> deleteItem) throws FlickrException {
        RequestContext.getRequestContext().setAuth(flickrAuthService.getAuth());
        for (String item : deleteItem) {
            flickr.getFlickr().getPhotosInterface().delete(item);
        }
    }
}
