package kr.co.photograph.jhgallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoConfig {

    private String photoId;
    private String title;
    private Flag flag;
}
