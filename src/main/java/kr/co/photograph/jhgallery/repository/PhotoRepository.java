package kr.co.photograph.jhgallery.repository;

import kr.co.photograph.jhgallery.model.MyPhoto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter @Setter
@Repository
public class PhotoRepository {

    private final Map<Integer, MyPhoto> photoStore = new LinkedHashMap<>();
    private static int index = 0;

    public void save(MyPhoto myPhoto) {
        photoStore.put(index++, myPhoto);
    }

    public MyPhoto findById(String id) {
        for (MyPhoto value : photoStore.values()) {
            if (value.getId().equals(id)) {
                return value;
            }
        }
        return null;
    }

    public void clear() {
        photoStore.clear();
    }
}
