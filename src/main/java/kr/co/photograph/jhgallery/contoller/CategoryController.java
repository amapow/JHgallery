package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public String categoryConfigView() {
        return "/admin/category-config";
    }
}
