package kr.co.photograph.jhgallery.model;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.photos.Permissions;
import com.flickr4java.flickr.photos.PhotosInterface;
import kr.co.photograph.jhgallery.service.FlickrApi;
import kr.co.photograph.jhgallery.service.FlickrAuthorize;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@Getter
public class Photo {
    FlickrAuthorize auth = new FlickrAuthorize();
    private FlickrApi flickr = new FlickrApi();
    private ArrayList<String> mediumUrl;
    private ArrayList<String> largeUrl;
    private ArrayList<String> title;

    public Photo() throws InvocationTargetException, NoSuchMethodException, FlickrException, IllegalAccessException {
        this.mediumUrl = flickr.getImages("Medium");
        this.largeUrl = flickr.getImages("Large");
        this.title = flickr.getImages("Title");
    }

    public ArrayList<String> searchPermissions(ArrayList<String> photoId) throws FlickrException {

        ArrayList<String> permissions = new ArrayList<>();
        for(int i = 0 ; i < photoId.size() ; i++) {
            PhotosInterface photosInterface = new PhotosInterface(auth.getApikey(), auth.getSecret(), new REST());
            if(photosInterface.getPerms(photoId.get(i)).isFamilyFlag() == true) {
                permissions.add("Private");
            }
            else permissions.add("Public");
        }
        return permissions;
    }
}
