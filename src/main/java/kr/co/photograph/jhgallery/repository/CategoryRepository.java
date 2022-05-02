package kr.co.photograph.jhgallery.repository;

import kr.co.photograph.jhgallery.domain.Category;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class CategoryRepository {

    private final List<Category> store = new ArrayList<>();
    private static int sequence = 0;

    public void save(Category category) {
        store.add(category);
    }
    public void clear() {
        store.clear();
    }

    @PostConstruct
    public void init() {
        save(new Category(".OMC", "Old man's cave"));
        save(new Category(".TLR", "The last romance in SEOUL"));
        save(new Category(".NULL", "NULL"));
        save(new Category(".Untitled", "Untitled"));
    }
}
