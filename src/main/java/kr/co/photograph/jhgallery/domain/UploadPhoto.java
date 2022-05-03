package kr.co.photograph.jhgallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadPhoto {


    private String uploadPhotoName;
    private String storePhotoName;
    private String uploadPhotoPath;
    private String title;
    private Flag flag;

    public UploadPhoto(String uploadPhotoName, String storePhotoName, String uploadPhotoPath, Flag flag) {
        this.uploadPhotoName = uploadPhotoName;
        this.storePhotoName = storePhotoName;
        this.uploadPhotoPath = uploadPhotoPath;
        this.flag = flag;
    }

    public UploadPhoto() {
    }
}
