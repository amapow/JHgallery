package kr.co.photograph.jhgallery.contoller;

import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.model.MyPhoto;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import kr.co.photograph.jhgallery.service.flickrservice.FlickrService;
import kr.co.photograph.jhgallery.service.photoservice.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class PhotoConfigController {

    private final PhotoRepository photoRepository;
    private final FlickrService flickrServiceAdmin;
    private final PhotoService photoServiceAdmin;

    @GetMapping("photo/config")
    public String configView(Model model) throws FlickrException {
        model.addAttribute("photoRepository", photoRepository.getPhotoStore());
        model.addAttribute("flag", Flag.values());
        log.info("photo store size = {}", photoRepository.getPhotoStore().size());

        return "/admin/photo-config";
    }

    @PostMapping("photo/config")
    public String configPhoto(@RequestParam String title, HttpServletRequest request) throws FlickrException {

        String[] getTitle = title.split(",");
        List<String> flag = getFlag(request, getTitle);
        List<String> titleList = new ArrayList<>();
        for (String s : getTitle) {
            titleList.add(s);
        }
        Map<Integer, MyPhoto> photoStore = photoRepository.getPhotoStore();
        int i = 0;
        for (MyPhoto value : photoStore.values()) {
            flickrServiceAdmin.config(value, titleList.get(i), flag.get(i), photoStore);
            i++;
        }
        photoServiceAdmin.refreshPhotoList();
        return "/admin/photo-config";
    }

    private List<String> getFlag(HttpServletRequest request, String[] getTitle) {

        List<String> getFlag = new ArrayList<>();
        for (int i = 0; i < getTitle.length; i++) {
            getFlag.add(request.getParameter("flag" + i));
        }
        return getFlag;
    }
}
