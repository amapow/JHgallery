package kr.co.photograph.jhgallery.contoller;

import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.PhotoConfig;
import kr.co.photograph.jhgallery.domain.dto.PhotoConfigDto;
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
        model.addAttribute("form", new PhotoConfigDto(photoRepository.returnConfig()));
        model.addAttribute("photoRepository", photoRepository.getPhotoStore());
        model.addAttribute("flag", Flag.values());

        return "/admin/photo-config";
    }

    @PostMapping("photo/config")
    public String configPhoto(@ModelAttribute("form") PhotoConfigDto form) throws FlickrException {
        List<PhotoConfig> photoConfigs = photoRepository.returnConfig();
        for(int i = 0; i < form.getPhotoConfig().size(); i++) {
            flickrServiceAdmin.config(
                    photoRepository.findById(photoConfigs.get(i).getPhotoId()),
                    form.getPhotoConfig().get(i).getTitle(),
                    form.getPhotoConfig().get(i).getFlag().getValue());
        }
        return "redirect:/admin/photo/config";
    }

    private List<String> getFlag(HttpServletRequest request, String[] getTitle) {

        List<String> getFlag = new ArrayList<>();
        for (int i = 0; i < getTitle.length; i++) {
            getFlag.add(request.getParameter("flag" + i));
        }
        return getFlag;
    }
}
