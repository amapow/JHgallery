package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.AuthStore;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FlickrUpload {
    private String apikey = "97edf61c3435783d407d85e214e0f2b7";
    private String secret = "cae4d7d188e32e86";
    private AuthStore authStore;

    private void authorize() throws  FlickrException, IOException {
        Flickr flickr = new Flickr(apikey, secret, new REST());
        AuthInterface authInterface = flickr.getAuthInterface();
        OAuth1RequestToken accessToken  = authInterface.getRequestToken();

        String url = authInterface.getAuthorizationUrl(accessToken, Permission.DELETE);
        System.out.println(url);
        String tokenKey=new Scanner(System.in).nextLine();

        OAuth1Token requestToken = authInterface.getAccessToken(accessToken, tokenKey);
        Auth auth = authInterface.checkToken((requestToken));
        RequestContext.getRequestContext().setAuth(auth);
    }



    public static void main(String[] args) throws FileNotFoundException, FlickrException, IOException {
        UploadTest authr = new UploadTest();
        String apikey = "97edf61c3435783d407d85e214e0f2b7";
        String secret = "cae4d7d188e32e86";
        Photo photo;

        Flickr flickr = new Flickr(apikey, secret, new REST());
        File file = new File("/Users/janghyeon/Pictures/4e5d667d2f4d0c.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        Uploader uploader = flickr.getUploader();
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        uploadMetaData.setTitle("Photo upload Test");
        String id = uploader.upload(fileInputStream, uploadMetaData);



        Photo p = flickr.getPhotosInterface().getPhoto(id, secret);
        String uploadedUrl = p.getLargeUrl();
        System.out.println(uploadedUrl);
    }
}
