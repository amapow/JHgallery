package kr.co.photograph.jhgallery.domain;

import lombok.Data;

import java.util.List;

@Data
public class UploadPhotos {

    private List<UploadPhoto> uploadPhotos;

    public UploadPhotos(List<UploadPhoto> uploadPhotos) {
        this.uploadPhotos = uploadPhotos;
    }
}
