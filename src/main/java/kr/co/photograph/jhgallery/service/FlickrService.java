package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;

import java.io.IOException;

public interface FlickrService {

    void authorize(String tokenKey) throws FlickrException, IOException;
    void upload() throws FlickrException;
    String getAuthUrl();
    void delete() throws FlickrException;
}
