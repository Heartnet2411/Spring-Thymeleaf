package se.fit.quanlydonhang.services;

import se.fit.quanlydonhang.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void saveProduct(Product product);
    List<Product> findAll();
    void updateProduct(Product product);
    void deleteProduct(Product product);
    Optional<Product> findById(String id);
    boolean delete(String id);
    List<Product> findByName(String name);
}
