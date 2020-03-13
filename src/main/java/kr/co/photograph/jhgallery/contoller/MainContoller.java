package kr.co.photograph.jhgallery.contoller;

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
    FlickrApi flick = new FlickrApi();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home_1() throws Exception {
        ArrayList<String> mediumPhotoList = flick.getImages("Medium");
        ArrayList<String> largePhotoList = flick.getImages("Large");
        ArrayList<String> titlePhotoList = flick.getImages("Title");
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("mediumModel", mediumPhotoList);
        photoModel.addObject("largeModel", largePhotoList);
        photoModel.addObject("titleModel", titlePhotoList);

        return photoModel;
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home_2() throws Exception {
        ArrayList<String> mediumPhotoList = flick.getImages("Medium");
        ArrayList<String> largePhotoList = flick.getImages("Large");
        ArrayList<String> titlePhotoList = flick.getImages("Title");
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("mediumModel", mediumPhotoList);
        photoModel.addObject("largeModel", largePhotoList);
        photoModel.addObject("titleModel", titlePhotoList);

        return photoModel;
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(Locale locale, Model model) {
        model.addAttribute("about", "about");
        return "about";
    }

    @RequestMapping(value = "blog", method = RequestMethod.GET)
    public String blog(Locale locale, Model model) {
        model.addAttribute("blog", "blog");
        return "blog";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Locale locale, Model model) {
        model.addAttribute("contact", "contact");
        return "contact";
    }

    @RequestMapping(value = "elements", method = RequestMethod.GET)
    public String elements(Locale locale, Model model) {
        model.addAttribute("elements", "elements");
        return "elements";
    }

    @RequestMapping(value = "portfolio", method = RequestMethod.GET)
    public String portfolio(Locale locale, Model model) {
        model.addAttribute("portfolio", "portfolio");
        return "portfolio";
    }
}

//    @Autowired
//    JavaMailSender javaMailSender;

//    @RequestMapping(value = "sendmail", method = RequestMethod.POST)
//    public String sendMail(String name, String eemail, String subject, String text) {
//        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
//            @Override
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//                helper.setFrom(eemail);
//                helper.setTo("amapow25@gmail.com");
//                helper.setSubject(subject + " from" + name);
//                helper.setText(text);
//            }
//        };
//        javaMailSender.send(preparator);
//        return "contact";
