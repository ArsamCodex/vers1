package webshopjavaaproach.vers1.repository;

import org.springframework.data.repository.CrudRepository;
import webshopjavaaproach.vers1.models.Category;

import java.util.Locale;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category getByName(String name);
    Category findById(int id);


}
