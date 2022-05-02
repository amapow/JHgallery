package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.domain.Category;
import kr.co.photograph.jhgallery.domain.dto.CategoryDto;
import kr.co.photograph.jhgallery.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

//    @ModelAttribute
//    public void addCategories(Model model) {
//        model.addAttribute("categories", categoryRepository.getStore());
//    }


    @GetMapping
    public String categoryConfigView(Model model) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategories(categoryRepository.getStore());
        model.addAttribute("form", categoryDto);
        model.addAttribute("addForm", new Category());
        return "/admin/category-config";
    }


    @PostMapping("edit")
    public String categoryConfigEdit(@ModelAttribute(name="form") CategoryDto form) {
        List<Category> store = categoryRepository.getStore();

        for(int i = 0; i < store.size(); i++) {
            if (! store.get(i).equals(form.getCategories().get(i))) {
                log.info("Change found, {}", form.getCategories().get(i).getTitle());
                store.get(i).setTitle(form.getCategories().get(i).getTitle());
                store.get(i).setDesc(form.getCategories().get(i).getDesc());
                log.info("change to {}", form.getCategories().get(i).getTitle());
            }

        }
        return "redirect:/admin/category";
    }

    @PostMapping("add")
    public String categoryConfigAdd(@ModelAttribute(name="addForm") Category addForm) {
        addForm.setTitle("."+addForm.getTitle());
        categoryRepository.save(addForm);
        return "redirect:/admin/category";
    }
}
