package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
@Setter
public class FlickrApi {
    String apikey = "055c7b929054f3e2a33e16344c946f54";
    String secret = "348f89836dcc91a7";
    String userId = "146330423@N07";
    public PhotoList<Photo> searchByUserId() throws FlickrException {
        Flickr flickr = new Flickr(apikey, secret, new REST());
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setUserId(userId);

        PhotoList<Photo> photoList = flickr.getPhotosInterface().search(searchParameters, 500, 0);
        return photoList;
    }

    public ArrayList<String> getImages(String option) throws FlickrException {
        PhotoList<Photo> photoList = searchByUserId();
        ArrayList<String> returnList = new ArrayList<>();
        Photo photo;
        int i = 0;
        Iterator photoIterator = photoList.iterator();
        if(option.equals("large")) {
            while (photoIterator.hasNext()) {
                i++;
                photo = (Photo) photoIterator.next();
                returnList.add(photo.getLargeUrl());
            }
        }
        else if (option.equals("medium")) {
            while (photoIterator.hasNext()) {
                i++;
                photo = (Photo) photoIterator.next();
                returnList.add(photo.getMediumUrl());
            }
        }
        else {
            System.out.println("Check your Option.");
            return null;
        }
        return returnList;
    }

    public void searchTest(String option) throws FlickrException {
        int i = 0;
        Photo photo;
        ArrayList<String> list = getImages(option);
        Iterator photoIterator = list.iterator();
        while (photoIterator.hasNext()) {
            i++;
            photo = (Photo) photoIterator.next();
            System.out.println(i + " - Description: " + photo.getLargeUrl());
        }
    }

//    public static void main(String[] args) throws FlickrException {
//        FlickrApi flickApi = new FlickrApi();
//        ArrayList<String> list = flickApi.getImages("large");
//        for(int i = 0 ; i < list.size() ; i++) {
//            System.out.println("index = " + i + list.get(i));
//        }
//    }
}
