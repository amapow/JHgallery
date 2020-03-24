package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.*;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.photos.Permissions;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.photos.upload.UploadInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.AuthStore;
import kr.co.photograph.jhgallery.model.Photo;
import kr.co.photograph.jhgallery.service.FlickrApi;
import kr.co.photograph.jhgallery.service.FlickrAuthorize;
import lombok.var;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.spi.http.HttpContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@Controller

@RequestMapping("/")
public class AdminController {
    FlickrAuthorize auth = new FlickrAuthorize();
    String url;
    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public ModelAndView setUrl() throws Exception {
        this.url = auth.getUrl();
        ModelAndView urlModel = new ModelAndView("admin/auth");
        urlModel.addObject("url", url);

        return urlModel;
    }

    @RequestMapping(value = "getAuth", method = RequestMethod.POST)
    public String getAuth(String token) throws FlickrException, IOException {
        auth.authorize(token);

        return "admin/admin";
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload(Locale locale, Model model) throws IOException, FlickrException {
        RequestContext.getRequestContext().setAuth(auth.getAuthStore().retrieve(auth.getUserId()));
        PhotosInterface pi = new PhotosInterface(auth.getApikey(), auth.getSecret(), new REST());
        Permissions perm = new Permissions();
        perm.setPublicFlag(true);
        pi.setPerms("48277974466", perm);
        System.out.println(pi.getPerms("48277974466").isFamilyFlag());

//        model.addAttribute("upload", "upload");
//        File file = new File("/Users/janghyeon/Pictures/4e5d667d2f4d0c.jpg");
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        Uploader uploader = auth.getFlickr().getUploader();
//        UploadMetaData uploadMetaData = new UploadMetaData();
//        uploadMetaData.setPublicFlag(true);
//        uploadMetaData.setTitle("Photo upload Test");
//        String id = uploader.upload(fileInputStream, uploadMetaData);
//
//        Photo p = auth.getFlickr().getPhotosInterface().getPhoto(id, auth.getSecret());
//        String uploadedUrl = p.getLargeUrl();
//        System.out.println(uploadedUrl);
        return "admin/upload";
    }
//
//    @RequestMapping(value = "authConfig", method = RequestMethod.GET)
//    public String authConfig(Locale locale, Model model) {
//        model.addAttribute("authConfig", "authConfig");
//        return "admin/authConfig";
//    }

    @RequestMapping(value = "authConfig", method = RequestMethod.GET)
    public ModelAndView authConfig() throws Exception {
        RequestContext.getRequestContext().setAuth(auth.getAuthStore().retrieve(auth.getUserId()));
        kr.co.photograph.jhgallery.model.Photo photo = new Photo();
        ModelAndView photoModel = new ModelAndView("admin/authConfig");
        photoModel.addObject("mediumModel", photo.getMediumUrl());
        photoModel.addObject("titleModel", photo.getTitle());

        return photoModel;
    }

    @RequestMapping(value = "categoryConfig", method = RequestMethod.GET)
    public String categoryConfig(Locale locale, Model model) {
        model.addAttribute("categoryConfig", "categoryConfig");
        return "admin/categoryConfig";
    }
}
