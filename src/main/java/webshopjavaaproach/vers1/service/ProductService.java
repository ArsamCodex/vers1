package webshopjavaaproach.vers1.service;

import org.springframework.stereotype.Component;
import webshopjavaaproach.vers1.models.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAll();
    Product findById(int id);
    Product findByName(String name);


}
