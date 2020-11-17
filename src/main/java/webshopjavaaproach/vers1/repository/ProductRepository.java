package webshopjavaaproach.vers1.repository;

import org.springframework.data.repository.CrudRepository;
import webshopjavaaproach.vers1.models.Product;

public interface ProductRepository extends CrudRepository<Product , Integer> {




    Product getByName(String name);
}
