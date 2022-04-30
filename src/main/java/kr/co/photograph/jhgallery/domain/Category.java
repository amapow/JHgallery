package kr.co.photograph.jhgallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Category {

    private final String title;
    private final String fullTitle;
}
