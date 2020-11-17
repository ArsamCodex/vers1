package webshopjavaaproach.vers1.controllers;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webshopjavaaproach.vers1.models.Category;
import webshopjavaaproach.vers1.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories")
    @ResponseBody
    public String findCategories(Model model){

        List<Category> categories = categoryService.getAll();

        model.addAttribute("categories",categories);

        return "category-list";


    }
    @RequestMapping("/category/{id}")
    public String getCategoryInfo(@PathVariable int id,Model model){

        Category category = categoryService.findById(id);

        model.addAttribute("category",category);

        return "category-info";



    }

}