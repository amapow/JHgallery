package kr.co.photograph.jhgallery.repository;

import kr.co.photograph.jhgallery.domain.UploadPhoto;
import kr.co.photograph.jhgallery.domain.UploadPhotos;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UploadPhotosRepository {

    private final Map<Integer, UploadPhotos> store = new HashMap<>();
    private int key = 0;

    public void save(UploadPhotos uploadPhoto) {
        store.put(++key, uploadPhoto);
    }

    public UploadPhotos findAll() {
        return store.get(key);
    }
}
