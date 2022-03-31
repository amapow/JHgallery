package kr.co.photograph.jhgallery.service;

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
import kr.co.photograph.jhgallery.component.Flickr;
import lombok.Getter;
import org.scribe.model.Verifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Getter
@Service
public class FlickerServiceAdmin implements FlickrService {
    private final String authUrl;
    private final AuthInterface authInterface;
    private final OAuth1RequestToken requestToken;
    private final Flickr flickr;
    private AuthStore authStore;
    private Auth auth;

    public FlickerServiceAdmin(kr.co.photograph.jhgallery.component.Flickr flickr) {
        authInterface = new AuthInterface(flickr.getApikey(), flickr.getSecret(), new REST());
        requestToken = authInterface.getRequestToken();
        authUrl = authInterface.getAuthorizationUrl(this.requestToken, Permission.DELETE);
        this.flickr = flickr;
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

        Uploader uploader = flickr.getFlickr().getUploader();
        RequestContext.getRequestContext().setAuth(auth);
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        uploadMetaData.setTitle("Photo upload Test");

        uploader.upload(file, uploadMetaData);
    }

    @Override
    public void delete(ArrayList<String> deleteItem) throws FlickrException {
        RequestContext.getRequestContext().setAuth(auth);
        for (String item : deleteItem) {
            flickr.getFlickr().getPhotosInterface().delete(item);
        }
    }
}
