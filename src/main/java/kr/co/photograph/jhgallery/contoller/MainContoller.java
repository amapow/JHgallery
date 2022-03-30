package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.service.FlickerServiceAdmin;
import kr.co.photograph.jhgallery.service.FlickrService;
import kr.co.photograph.jhgallery.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home_1() throws Exception {
        ArrayList<String> mediumUrl = photoService.getImages("Medium");
        ArrayList<String> largeUrl = photoService.getImages("Large");
        ArrayList<String> titleUrl = photoService.getImages("Title");

        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("mediumModel", mediumUrl);
        photoModel.addObject("largeModel", largeUrl);
        photoModel.addObject("titleModel", titleUrl);

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