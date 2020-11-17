package webshopjavaaproach.vers1.service;

import org.springframework.stereotype.Component;
import webshopjavaaproach.vers1.models.Product;
import webshopjavaaproach.vers1.repository.ProductRepository;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Product p = productRepository.findById(id).orElse(null);
        return p;
    }

    @Override
    public Product findByName(String name) {
        return productRepository.getByName(name);
    }
}
