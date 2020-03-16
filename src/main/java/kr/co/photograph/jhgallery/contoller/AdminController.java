package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.photos.Photo;
import kr.co.photograph.jhgallery.service.FlickrApi;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Locale;

@Controller

@RequestMapping("/")
public class AdminController {

    @RequestMapping(value = "admin/imageSelector", method = RequestMethod.GET)
    public ModelAndView ImageSelector() throws Exception {
        FlickrApi flick = new FlickrApi();
        ArrayList<String> mediumPhotoList = flick.getImages("Medium");
        ArrayList<String> largePhotoList = flick.getImages("Large");
        ArrayList<String> titlePhotoList = flick.getImages("Title");
        ModelAndView photoModel = new ModelAndView("admin/imageSelector");
        photoModel.addObject("mediumModel", mediumPhotoList);
        photoModel.addObject("largeModel", largePhotoList);
        photoModel.addObject("titleModel", titlePhotoList);

        return photoModel;
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload(Locale locale, Model model) {
        model.addAttribute("upload", "upload");
        return "admin/upload";
    }

    @RequestMapping(value = "authConfig", method = RequestMethod.GET)
    public String authConfig(Locale locale, Model model) {
        model.addAttribute("authConfig", "authConfig");
        return "admin/authConfig";
    }

    @RequestMapping(value = "categoryConfig", method = RequestMethod.GET)
    public String categoryConfig(Locale locale, Model model) {
        model.addAttribute("categoryConfig", "categoryConfig");
        return "admin/categoryConfig";
    }
}
