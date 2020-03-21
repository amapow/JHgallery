package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.model.Photo;
import kr.co.photograph.jhgallery.service.FlickrApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Locale;

@Controller

@RequestMapping("/")
public class MainContoller {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home_1() throws Exception {
        Photo photo = new Photo();
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("mediumModel", photo.getMediumUrl());
        photoModel.addObject("largeModel", photo.getLargeUrl());
        photoModel.addObject("titleModel", photo.getTitle());

        return photoModel;
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(Locale locale, Model model) {
        model.addAttribute("about", "about");
        return "about";
    }


    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Locale locale, Model model) {
        model.addAttribute("contact", "contact");
        return "contact";
    }
}