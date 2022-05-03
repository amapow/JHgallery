package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.contoller.form.PhotoForm;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.UploadPhoto;
import kr.co.photograph.jhgallery.domain.dto.UploadPhotoDto;
import kr.co.photograph.jhgallery.file.FileStore;
import kr.co.photograph.jhgallery.repository.UploadPhotoRepository;
import kr.co.photograph.jhgallery.service.flickrservice.FlickrService;
import kr.co.photograph.jhgallery.service.photoservice.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("admin")
public class UploadController {

    private final FlickrService flickrService;
    private final FileStore fileStore;
    private final UploadPhotoRepository uploadPhotoRepository;
    private final PhotoService photoServiceAdmin;

    @GetMapping("/upload")
    public String uploadView() {
        return "/admin/upload-view";
    }

    @PostMapping("/upload")
    public String uploadPhoto(@ModelAttribute PhotoForm form, Model model) throws IOException {
        List<UploadPhoto> storePhotos = fileStore.storeFiles(form.getUploadPhotos());
        uploadPhotoRepository.save(new UploadPhotoDto(storePhotos));
        UploadPhotoDto photos = uploadPhotoRepository.findAll();
        model.addAttribute("photos", photos);
        model.addAttribute("flag", Flag.values());
        return "/admin/upload-setting";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }


//    @PostMapping("/upload/setting")
//    public String uploadSetting(@RequestParam String title, HttpServletRequest request) throws FlickrException {
//        String[] getTitle = title.split(",");
//        List<String> flag = getFlag(request, getTitle);
//        List<UploadPhoto> uploadPhotos = uploadPhotoRepository.findAll().getUploadPhotos();
//        uploadPhotoSetting(getTitle, flag, uploadPhotos);
//        for (UploadPhoto uploadPhoto : uploadPhotos) {
//            flickrService.upload(getFullPath(uploadPhoto.getStorePhotoName()), uploadPhoto.getTitle(), uploadPhoto.getPermissionFlag());
//            new File(getFullPath(uploadPhoto.getStorePhotoName())).delete();
//        }
//        uploadPhotoRepository.clear();
//        photoServiceAdmin.refreshPhotoList();
//        return "redirect:/admin";
//    }

    @PostMapping("/upload/setting")
    public String uploadSetting(@ModelAttribute("photos") UploadPhotoDto uploadPhotoDto) throws FlickrException {
        List<UploadPhoto> uploadPhotos = uploadPhotoRepository.findAll().getUploadPhotos();
        for (int i = 0; i < uploadPhotos.size(); i++) {
            flickrService.upload(getFullPath(uploadPhotos.get(i).getStorePhotoName()),
                    uploadPhotoDto.getUploadPhotos().get(i).getTitle(),
                    uploadPhotoDto.getUploadPhotos().get(i).getFlag().getValue());
            new File(getFullPath(uploadPhotoDto.getUploadPhotos().get(i).getStorePhotoName())).delete();
        }
        uploadPhotoRepository.clear();
        photoServiceAdmin.refreshPhotoList();
        return "redirect:/admin";
    }

    private String getFullPath(String uploadPhoto) {
        return fileStore.getFullPath(uploadPhoto);
    }
}
