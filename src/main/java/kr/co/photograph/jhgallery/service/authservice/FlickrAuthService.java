package kr.co.photograph.jhgallery.service.authservice;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.auth.Auth;

public interface FlickrAuthService {

    void authorize(String tokenKey) throws FlickrException;
    String getAuthUrl();
    Auth getAuth();
}
