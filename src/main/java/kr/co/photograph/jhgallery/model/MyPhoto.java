package kr.co.photograph.jhgallery.model;


import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class MyPhoto {

    private final String id;
    private final String largeUrl;
    private final String mediumUrl;
    private final String title;
    private  int index;
    private String flag;

    public MyPhoto(String id, String largeUrl, String mediumUrl, String title, int index) {
        this.id = id;
        this.largeUrl = largeUrl;
        this.mediumUrl = mediumUrl;
        this.title = title;
        this.index = index;
    }

    public MyPhoto(String id, String largeUrl, String mediumUrl, String title) {
        this.id = id;
        this.largeUrl = largeUrl;
        this.mediumUrl = mediumUrl;
        this.title = title;
    }

    public MyPhoto(String id, String largeUrl, String mediumUrl, String title, String flag) {
        this.id = id;
        this.largeUrl = largeUrl;
        this.mediumUrl = mediumUrl;
        this.title = title;
        this.flag = flag;
    }
}
