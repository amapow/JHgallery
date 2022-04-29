package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.model.MyPhoto;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import kr.co.photograph.jhgallery.service.photoservice.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final PhotoService photoServiceMain;
    private final PhotoRepository photoRepository;

    @ModelAttribute

    @GetMapping
    public ModelAndView home_1() throws Exception {
        photoServiceMain.refreshPhotoList();
        Map<Integer, MyPhoto> photoStore = photoRepository.getPhotoStore();
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("photoRepository", photoRepository.getPhotoStore());
        return photoModel;
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
}