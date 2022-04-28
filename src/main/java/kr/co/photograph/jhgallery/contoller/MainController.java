package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.service.photoservice.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final PhotoService photoServiceMain;

    @GetMapping
    public ModelAndView home_1() throws Exception {
        photoServiceMain.refreshPhotoList();
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("myPhotoList", photoServiceMain.getMyPhotoList());
        return photoModel;
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
}