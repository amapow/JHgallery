package kr.co.photograph.jhgallery.component;

import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Flickr {

    private final String apikey;
    private final String secret;
    private final com.flickr4java.flickr.Flickr flickr;

    public Flickr(@Value("${flickr.apikey}") String apikey,
                  @Value("${flickr.secret}") String secret) {
        this.apikey = apikey;
        this.secret = secret;
        flickr = new com.flickr4java.flickr.Flickr(apikey, secret, new REST());
    }



}
