package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.util.AuthStore;

import java.io.IOException;

public interface FlickrService {

    void authorize(String tokenKey) throws FlickrException, IOException;
    void upload() throws FlickrException;
    String getUrl();
    AuthStore getAuthStore();
    String getUserId();
}
