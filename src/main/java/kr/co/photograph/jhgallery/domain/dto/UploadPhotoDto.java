package kr.co.photograph.jhgallery.domain.dto;

import kr.co.photograph.jhgallery.domain.UploadPhoto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UploadPhotoDto {

    private List<UploadPhoto> uploadPhotos;

    public UploadPhotoDto(List<UploadPhoto> uploadPhotos) {
        this.uploadPhotos = uploadPhotos;
    }
}
