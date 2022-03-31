package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.model.PhotoSet;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    private final PhotoSet photoSet;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home_1() throws Exception {

        photoSet.refreshPhotoSet(); // delete 구현 전 임시 로직
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("mediumModel", photoSet.getMediumUrl());
        photoModel.addObject("largeModel", photoSet.getLargeUrl());
        photoModel.addObject("titleModel", photoSet.getTitle());

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