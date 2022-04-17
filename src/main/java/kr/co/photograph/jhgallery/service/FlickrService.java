package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.FlickrException;

import java.util.ArrayList;

public interface FlickrService {

    void upload() throws FlickrException;
    void delete(ArrayList<String> deleteItem) throws FlickrException;
}
