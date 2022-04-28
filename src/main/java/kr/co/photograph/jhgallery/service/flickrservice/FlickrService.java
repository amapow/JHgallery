package kr.co.photograph.jhgallery.service.flickrservice;

import com.flickr4java.flickr.FlickrException;

import java.util.ArrayList;

public interface FlickrService {

    void upload(String fileName, String title, String flag) throws FlickrException;
    void delete(ArrayList<String> deleteItem) throws FlickrException;
}
