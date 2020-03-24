package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Method;

@Getter
public class FlickrApi extends FlickrAuthorize{
    FlickrAuthorize auth = new FlickrAuthorize();

    public PhotoList<Photo> searchByUserId() throws FlickrException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setUserId(auth.getUserId());

        PhotoList<Photo> photoList = auth.getFlickr().getPhotosInterface().search(searchParameters, 500, 0);
        return photoList;
    }

    public ArrayList<String> search(PhotoList<Photo> photoList, String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Iterator photoIterator = photoList.iterator();
        ArrayList<String> returnList = new ArrayList<>();
        Photo photo;
        if(option.equals("Large")) {
            option = "getLargeUrl";
        }
        else if(option.equals("Medium")) {
            option = "getMediumUrl";
        }
        else if(option.equals("Title")) {
            option = "getTitle";
        }
        else if(option.equals("Id")) {
            option = "getId";
        }
        else {
            System.out.println("Check your option");
            return null;
        }
        Method method = Photo.class.getDeclaredMethod(option);
        method.setAccessible(true);
        while (photoIterator.hasNext()) {
            photo = (Photo) photoIterator.next();

            returnList.add((method.invoke(photo).toString()));
        }
        return returnList;
    }
    public ArrayList<String> getImages(String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PhotoList<Photo> photoList = searchByUserId();
        ArrayList<String> returnList = search(photoList, option);
        return returnList;
    }
}
