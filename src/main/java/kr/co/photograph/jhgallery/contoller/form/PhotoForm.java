package kr.co.photograph.jhgallery.contoller.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PhotoForm {
    private List<MultipartFile> uploadPhotos;
}
