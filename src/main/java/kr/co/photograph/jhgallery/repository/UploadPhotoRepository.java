package kr.co.photograph.jhgallery.repository;

import kr.co.photograph.jhgallery.domain.dto.UploadPhotoDto;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class UploadPhotoRepository {

    private final Map<Integer, UploadPhotoDto> store = new LinkedHashMap<>();
    private int key = 0;

    public void save(UploadPhotoDto uploadPhoto) {
        store.put(++key, uploadPhoto);
    }

    public UploadPhotoDto findAll() {
        return store.get(key);
    }

    public void clear() {
        store.clear();
    }
}
