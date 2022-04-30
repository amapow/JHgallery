package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.domain.Category;
import kr.co.photograph.jhgallery.model.MyPhoto;
import kr.co.photograph.jhgallery.repository.CategoryRepository;
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

    private final PhotoService photoServiceAdmin;
    private final PhotoRepository photoRepository;
    private final CategoryRepository categoryRepository;

    @ModelAttribute

    @GetMapping
    public ModelAndView home_1() throws Exception {
//        photoServiceAdmin.refreshPhotoList();
        Map<Integer, MyPhoto> photoStore = photoRepository.getPhotoStore();
        ModelAndView photoModel = new ModelAndView("home");
        photoModel.addObject("categories", categoryRepository.getStore());
        photoModel.addObject("photoRepository", photoRepository.getPhotoStore());
        return photoModel;
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
}