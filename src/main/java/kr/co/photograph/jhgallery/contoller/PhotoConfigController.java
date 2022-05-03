package kr.co.photograph.jhgallery.contoller;

import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.PhotoConfig;
import kr.co.photograph.jhgallery.domain.dto.PhotoConfigDto;
import kr.co.photograph.jhgallery.repository.PhotoRepository;
import kr.co.photograph.jhgallery.service.flickrservice.FlickrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class PhotoConfigController {

    private final PhotoRepository photoRepository;
    private final FlickrService flickrServiceAdmin;

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
}
