package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final PhotoService photoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home_1() throws Exception {
        photoService.refreshPhotoList();
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("myPhotoList", photoService.getMyPhotoList());
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