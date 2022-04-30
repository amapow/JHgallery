package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import kr.co.photograph.jhgallery.service.authservice.FlickrAuthService;
import kr.co.photograph.jhgallery.service.flickrservice.FlickrService;
import kr.co.photograph.jhgallery.service.photoservice.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final FlickrAuthService flickrAuthService;
    private final FlickrService flickrService;
    private final PhotoService photoServiceAdmin;
    private final PhotoRepository photoRepository;


    @GetMapping
    public String admin(Model model) throws FlickrException {
//        model.addAttribute("myPhotoList", photoServiceAdmin.getMyPhotoList());
        model.addAttribute("photoRepository", photoRepository.getPhotoStore());
//        photoServiceAdmin.refreshPhotoList();
        return "/admin/admin";
    }

    @GetMapping("auth")
    public String setUrl(Model model) {
        String url = flickrAuthService.getAuthUrl();
        model.addAttribute("url", url);
        return "/admin/auth";
    }

    @PostMapping("auth")
    public String getAuth(@RequestParam("token") String token) throws FlickrException {
        System.out.println(token);
        flickrAuthService.authorize(token);
        photoServiceAdmin.refreshPhotoList();
        return "redirect:/admin";
    }

    @GetMapping("delete")
    public String delete(Model model) throws IOException, FlickrException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        model.addAttribute("photoRepository", photoRepository.getPhotoStore());
        return "admin/delete";
    }

    @PostMapping("delete")
    public String deleteItem(@RequestParam String id) {
        String[] deleteStringId = id.split(",");
        ArrayList<String> deleteIdArray = new ArrayList<>();
        try {
            for (String item : deleteStringId) {
                deleteIdArray.add(item);
            }
            flickrService.delete(deleteIdArray);
            photoServiceAdmin.refreshPhotoList();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("삭제 항목을 재선택 하세용");
        } catch (FlickrException e) {
            e.getErrorCode();
            System.out.println("Authorize를 수행하세영");
        }
        return "redirect:/admin/delete";
    }

    @GetMapping("/home")
    public String toHome() {
        return "redirect:/";
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String missingDeleteItemParams(MissingServletRequestParameterException e) {
        String id = e.getParameterName();
        System.out.println(id + " parameter is missing");
        return "redirect:/admin";
    }
}
