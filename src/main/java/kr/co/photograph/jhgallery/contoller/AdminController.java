package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.*;
import kr.co.photograph.jhgallery.service.FlickerServiceAdmin;
import kr.co.photograph.jhgallery.service.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private FlickrService flickrService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public ModelAndView setUrl() throws Exception {
        final String url = flickrService.getUrl();
        ModelAndView urlModel = new ModelAndView("admin/auth");
        urlModel.addObject("url", url);

        return urlModel;
    }

    @RequestMapping(value = "getAuth", method = RequestMethod.POST)
    public String getAuth(String token) throws FlickrException, IOException {
        flickrService.authorize(token);

        return "redirect:/admin";
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload(Locale locale, Model model) throws IOException, FlickrException {
        model.addAttribute("upload", "admin/upload");
        flickrService.upload();

        return "redirect:/admin";
    }

//    @RequestMapping(value = "authConfig", method = RequestMethod.GET)
//    public ModelAndView authConfig() throws Exception {
//        RequestContext.getRequestContext().setAuth(flickrService.getAuthStore().retrieve(flickrService.getUserId()));
//        kr.co.photograph.jhgallery.model.Photo photo = new Photo();
//        ModelAndView photoModel = new ModelAndView("admin/authConfig");
//        photoModel.addObject("mediumModel", photo.getMediumUrl());
//        photoModel.addObject("titleModel", photo.getTitle());
//
//        return photoModel;
//    }

    @RequestMapping(value = "categoryConfig", method = RequestMethod.GET)
    public String categoryConfig(Locale locale, Model model) {
        model.addAttribute("categoryConfig", "categoryConfig");
        return "admin/categoryConfig";
    }
}
