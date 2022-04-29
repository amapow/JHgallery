package kr.co.photograph.jhgallery.contoller;


import com.flickr4java.flickr.FlickrException;
import kr.co.photograph.jhgallery.contoller.form.PhotoForm;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.UploadPhoto;
import kr.co.photograph.jhgallery.domain.UploadPhotos;
import kr.co.photograph.jhgallery.file.FileStore;
import kr.co.photograph.jhgallery.repository.UploadPhotosRepository;
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
    private final UploadPhotosRepository uploadPhotoRepository;

    @GetMapping("/upload")
    public String uploadView() {
        return "/admin/upload-view";
    }

    @PostMapping("/upload")
    public String uploadPhoto(@ModelAttribute PhotoForm form, Model model) throws IOException {
        List<UploadPhoto> storePhotos = fileStore.storeFiles(form.getUploadPhotos());
        uploadPhotoRepository.save(new UploadPhotos(storePhotos));
        UploadPhotos photos = uploadPhotoRepository.findAll();
        model.addAttribute("photos", photos);
        model.addAttribute("flag", Flag.values());
        return "/admin/upload-setting";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }


    @PostMapping("/upload/setting")
    public String uploadSetting(@RequestParam String title, HttpServletRequest request) throws FlickrException {
        String[] getTitle = title.split(",");
        List<String> flag = getFlag(request, getTitle);
        List<UploadPhoto> uploadPhotos = uploadPhotoRepository.findAll().getUploadPhotos();
        uploadPhotoSetting(getTitle, flag, uploadPhotos);
        for (UploadPhoto uploadPhoto : uploadPhotos) {
            flickrService.upload(getFullPath(uploadPhoto.getStorePhotoName()), uploadPhoto.getTitle(), uploadPhoto.getPermissionFlag());
            new File(getFullPath(uploadPhoto.getStorePhotoName())).delete();
        }
        uploadPhotoRepository.clear();
        return "redirect:/admin";
    }

    private String getFullPath(String uploadPhoto) {
        return fileStore.getFullPath(uploadPhoto);
    }

    private void uploadPhotoSetting(String[] getTitle, List<String> flag, List<UploadPhoto> uploadPhotos) {
        for (int i = 0; i < getTitle.length; i++) {
            uploadPhotos.get(i).setTitle(getTitle[i]);
            uploadPhotos.get(i).setPermissionFlag(flag.get(i));
        }
    }

    private List<String> getFlag(HttpServletRequest request, String[] getTitle) {
        List<String> getFlag = new ArrayList<>();
        for (int i = 0; i < getTitle.length; i++) {
            getFlag.add(request.getParameter("flag" + i));
        }
        return getFlag;
    }
}
