package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.AuthStore;
import com.flickr4java.flickr.util.FileAuthStore;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import lombok.Getter;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Getter
@Service
public class FlickerServiceAdmin implements FlickrService {
    private final String apikey;
    private final String secret;
    private final String userId;
    private final Flickr flickr;
    private final String url;
    private final AuthInterface authInterface;
    private final OAuth1RequestToken requestToken;
    private AuthStore authStore;
    private Auth auth;

    public FlickerServiceAdmin(@Value("${flickr.apikey}") String apikey,
                               @Value("${flickr.secret}") String secret,
                               @Value("${flickr.userId}") String userId) {
        this.apikey = apikey;
        this.secret = secret;
        this.userId = userId;
        authInterface = new AuthInterface(apikey, secret, new REST());
        requestToken = authInterface.getRequestToken();
        url = authInterface.getAuthorizationUrl(this.requestToken, Permission.DELETE);
        flickr = new Flickr(apikey, secret, new REST());
    }

    @Override
    public void authorize(String tokenKey) throws FlickrException, IOException {
        OAuth1Token accessToken = authInterface.getAccessToken(this.requestToken, new Verifier(tokenKey).getValue());
        auth = authInterface.checkToken(accessToken);
        RequestContext.getRequestContext().setAuth(auth);
        File file = new File("/Users/janghyeon/authstore");
        File file2 = new File("/home/janghyeon/service_jhgallery/config");
        authStore = new FileAuthStore(file);
        authStore.store(auth);
    }

    @Override
    public void upload() throws FlickrException{
        File file = new File("/Users/janghyeon/Pictures/8a7ca600f906.jpeg");

        Uploader uploader = flickr.getUploader();
        RequestContext.getRequestContext().setAuth(auth);
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        uploadMetaData.setTitle("Photo upload Test");

        uploader.upload(file, uploadMetaData);
    }

    @Override
    public void delete() throws FlickrException {
        RequestContext.getRequestContext().setAuth(auth);
        flickr.getPhotosInterface().delete("51971212675");
    }
}
