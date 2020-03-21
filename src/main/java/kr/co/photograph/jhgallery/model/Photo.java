package kr.co.photograph.jhgallery.model;

import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.service.FlickrApi;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@Getter
public class Photo {
    private FlickrApi flickr = new FlickrApi();
    private ArrayList<String> mediumUrl;
    private ArrayList<String> largeUrl;
    private ArrayList<String> title;

    public Photo() throws InvocationTargetException, NoSuchMethodException, FlickrException, IllegalAccessException {
        this.mediumUrl = flickr.getImages("Medium");
        this.largeUrl = flickr.getImages("Large");
        this.title = flickr.getImages("Title");
    }
}
