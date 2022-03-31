package kr.co.photograph.jhgallery.model;


import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.service.PhotoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class PhotoSet {

    private final PhotoService photoService;

    private List<String> largeUrl = new ArrayList<>();
    private List<String> mediumUrl = new ArrayList<>();
    private List<String> title = new ArrayList<>();

    @PostConstruct
    void initialize() throws FlickrException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        largeUrl = photoService.getImages("Large");
        mediumUrl = photoService.getImages("Medium");
        title = photoService.getImages("Title");
    }

    public void refreshPhotoSet() throws FlickrException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        largeUrl = photoService.getImages("Large");
        mediumUrl = photoService.getImages("Medium");
        title = photoService.getImages("Title");
    }
}
