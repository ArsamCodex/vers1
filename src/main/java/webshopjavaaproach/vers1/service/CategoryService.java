package webshopjavaaproach.vers1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import webshopjavaaproach.vers1.models.Category;

import java.util.List;
import java.util.Locale;


public interface CategoryService {

    List<Category> getAll();

    Category findById(int id);
}
