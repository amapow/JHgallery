package kr.co.photograph.jhgallery.domain.dto;

import kr.co.photograph.jhgallery.domain.Category;
import kr.co.photograph.jhgallery.domain.Flag;
import kr.co.photograph.jhgallery.domain.PhotoConfig;
import kr.co.photograph.jhgallery.model.MyPhoto;
import lombok.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhotoConfigDto {

    private List<PhotoConfig> photoConfig;

    public void add(PhotoConfig photoConfig) {
        this.photoConfig.add(photoConfig);
    }
}
