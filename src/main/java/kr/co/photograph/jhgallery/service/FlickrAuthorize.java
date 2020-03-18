package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.util.AuthStore;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import lombok.Getter;
import org.scribe.model.Verifier;

import java.io.IOException;
import java.util.Scanner;

@Getter
public class FlickrAuthorize {
    private String apikey = "97edf61c3435783d407d85e214e0f2b7";
    private String secret = "cae4d7d188e32e86";
    private String userId = "146330423@N07";
    private Flickr flickr = new Flickr(apikey, secret, new REST());
    private AuthStore authStore;

    public void authorize() throws FlickrException, IOException {

        AuthInterface authInterface = flickr.getAuthInterface();
        OAuth1RequestToken RequestToken  = authInterface.getRequestToken();
        String url = authInterface.getAuthorizationUrl(RequestToken, Permission.DELETE);
        System.out.println(url);
        String tokenKey=new Scanner(System.in).nextLine();

        OAuth1Token accessToken = authInterface.getAccessToken(RequestToken, new Verifier(tokenKey).getValue());
        Auth auth = authInterface.checkToken((accessToken));
        RequestContext.getRequestContext().setAuth(auth);
    }
}
