package kr.co.photograph.jhgallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    private String title;
    private String desc;
}
