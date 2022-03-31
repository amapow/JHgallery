package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;


@Getter
@Service
public class PhotoServiceImpl implements PhotoService {

    private final String apikey;
    private final String secret;
    private final String userId;
    private final Flickr flickr;

    public PhotoServiceImpl(@Value("${flickr.apikey}") String apikey,
                            @Value("${flickr.secret}") String secret,
                            @Value("${flickr.userId}") String userId) {
        this.apikey = apikey;
        this.secret = secret;
        this.userId = userId;
        flickr = new Flickr(apikey, secret, new REST());
    }

    @Override
    public ArrayList<String> search(PhotoList<Photo> photoList, String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Iterator photoIterator = photoList.iterator();
        ArrayList<String> returnList = new ArrayList<>();
        Photo photo;
        String selectedOption;
        if(option.equals("Large")) {
            selectedOption = "getLargeUrl";
        }
        else if(option.equals("Medium")) {
            selectedOption = "getMediumUrl";
        }
        else if(option.equals("Title")) {
            selectedOption = "getTitle";
        }
        else if(option.equals("Id")) {
            selectedOption = "getId";
        }
        else {
            System.out.println("Check your option");
            return null;
        }
        Method method = Photo.class.getDeclaredMethod(selectedOption);
        method.setAccessible(true);
        while (photoIterator.hasNext()) {
            photo = (Photo) photoIterator.next();

            returnList.add((method.invoke(photo).toString()));
        }
        return returnList;
    }

    @Override
    public PhotoList<Photo> searchByUserId() throws FlickrException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setUserId(userId);

        PhotoList<Photo> photoList = flickr.getPhotosInterface().search(searchParameters, 500, 0);
        return photoList;
    }

    @Override
    public ArrayList<String> getImages(String option) throws FlickrException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PhotoList<Photo> photoList = searchByUserId();
        ArrayList<String> returnList = search(photoList, option);
        return returnList;
    }
}
