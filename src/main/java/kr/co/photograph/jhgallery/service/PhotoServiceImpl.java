package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;


@Getter
@Service
public class PhotoServiceImpl implements PhotoService {

    private String apikey;
    private String secret;
    private String userId;
    private Flickr flickr;

    @Autowired
    public PhotoServiceImpl(@Value("${flickr.apikey}") String apikey,
                            @Value("${flickr.secret}") String secret,
                            @Value("${flickr.userId}") String userId) {
        this.apikey = apikey;
        this.secret = secret;
        this.userId = userId;
        this.flickr = new Flickr(apikey, secret, new REST());
    }

    public PhotoServiceImpl() {}

    @Override
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
