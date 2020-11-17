package webshopjavaaproach.vers1.service;

import org.springframework.stereotype.Component;
import webshopjavaaproach.vers1.models.Category;
import webshopjavaaproach.vers1.repository.CategoryRepository;

import java.util.List;
import java.util.Locale;
@Component
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
