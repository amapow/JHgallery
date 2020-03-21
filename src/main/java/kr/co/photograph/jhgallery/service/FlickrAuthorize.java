package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.util.AuthStore;
import com.flickr4java.flickr.util.FileAuthStore;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import lombok.Getter;
import lombok.Setter;
import org.scribe.model.Verifier;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Setter
@Getter
public class FlickrAuthorize {
    private String apikey = "97edf61c3435783d407d85e214e0f2b7";
    private String secret = "cae4d7d188e32e86";
    private String userId = "146330423@N07";
    private Flickr flickr = new Flickr(apikey, secret, new REST());
    private String url;
    private AuthInterface authInterface;
    private OAuth1RequestToken requestToken;
    private AuthStore authStore;

    public FlickrAuthorize() {
        this.authInterface = flickr.getAuthInterface();
        this.requestToken = authInterface.getRequestToken();
        this.url = authInterface.getAuthorizationUrl(this.requestToken, Permission.DELETE);
    }

    public void authorize(String tokenKey) throws FlickrException, IOException {
        OAuth1Token accessToken = authInterface.getAccessToken(this.requestToken, new Verifier(tokenKey).getValue());
        Auth auth = this.authInterface.checkToken(accessToken);
        RequestContext.getRequestContext().setAuth(auth);
        File file = new File("/Users/janghyeon/authstore");
        File file2 = new File("/home/janghyeon/service_jhgallery/config");
        this.authStore = new FileAuthStore(file2);
        this.authStore.store(auth);
        System.out.println("Auth Done!!");
    }
}
