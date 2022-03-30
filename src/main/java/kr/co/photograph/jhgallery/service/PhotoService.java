package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public interface PhotoService {
    ArrayList<String> search(PhotoList<Photo> photoList, String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    PhotoList<Photo> searchByUserId() throws FlickrException;
    ArrayList<String> getImages(String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
