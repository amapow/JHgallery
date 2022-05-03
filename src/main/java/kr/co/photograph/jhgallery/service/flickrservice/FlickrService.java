package kr.co.photograph.jhgallery.service.flickrservice;

import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.model.MyPhoto;

import java.util.ArrayList;
import java.util.Map;

public interface FlickrService {

    void upload(String fileName, String title, String flag) throws FlickrException;
    void delete(ArrayList<String> deleteItem) throws FlickrException;

    void config(MyPhoto myPhoto, String title, String flag) throws FlickrException;
}
