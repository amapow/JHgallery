package kr.co.photograph.jhgallery.service.photoservice;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import kr.co.photograph.jhgallery.model.MyPhoto;

import java.util.ArrayList;

public interface PhotoService {
    PhotoList<Photo> searchByUserId() throws FlickrException;
    void searchToMyPhoto() throws FlickrException;
    void refreshPhotoList() throws FlickrException;
}
