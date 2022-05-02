package kr.co.photograph.jhgallery.domain.dto;

import kr.co.photograph.jhgallery.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private List<Category> categories;

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public CategoryDto() {
    }

    public CategoryDto(List<Category> categories) {
        this.categories = categories;
    }
}
