package kr.co.photograph.jhgallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public enum Flag {
    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE");

    private String value;

    Flag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
