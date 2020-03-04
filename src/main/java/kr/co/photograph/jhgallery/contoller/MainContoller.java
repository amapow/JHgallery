package kr.co.photograph.jhgallery.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller

@RequestMapping("/")
public class MainContoller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home_1 (Locale locale, Model model) {
        model.addAttribute("home", "home");
        return "home";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home_2 (Locale locale, Model model) {
        model.addAttribute("home", "home");
        return "home";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about (Locale locale, Model model) {
        model.addAttribute("about", "about");
        return "about";
    }

    @RequestMapping(value = "blog", method = RequestMethod.GET)
    public String blog (Locale locale, Model model) {
        model.addAttribute("blog", "blog");
        return "blog";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact (Locale locale, Model model) {
        model.addAttribute("contact", "contact");
        return "contact";
    }

    @RequestMapping(value = "elements", method = RequestMethod.GET)
    public String elements (Locale locale, Model model) {
        model.addAttribute("elements", "elements");
        return "elements";
    }

    @RequestMapping(value = "portfolio", method = RequestMethod.GET)
    public String portfolio (Locale locale, Model model) {
        model.addAttribute("portfolio", "portfolio");
        return "portfolio";
    }

}
