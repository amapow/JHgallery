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
    FlickrAuthorize auth;

    public void upload() throws FileNotFoundException, FlickrException {
        Flickr flickr = new Flickr(auth.getApikey(), auth.getSecret(), new REST());
        Auth uploadAuth = auth.getAuthStore().retrieve(auth.getUserId());
        RequestContext.getRequestContext().setAuth(uploadAuth);
        System.out.println(uploadAuth.getUser() + uploadAuth.getToken() + uploadAuth.getPermission());
        File file = new File("/Users/janghyeon/Pictures/4e5d667d2f4d0c.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        Uploader uploader = flickr.getUploader();
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        uploadMetaData.setTitle("Photo upload Test");
        String id = uploader.upload(fileInputStream, uploadMetaData);

        Photo p = flickr.getPhotosInterface().getPhoto(id, uploadAuth.getTokenSecret());
        String uploadedUrl = p.getLargeUrl();
        System.out.println(uploadedUrl);
    }

}
