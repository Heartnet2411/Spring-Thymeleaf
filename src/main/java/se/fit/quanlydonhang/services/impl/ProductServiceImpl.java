package se.fit.quanlydonhang.services.impl;

import org.springframework.stereotype.Service;
import se.fit.quanlydonhang.models.Product;
import se.fit.quanlydonhang.repositories.ProductRepo;
import se.fit.quanlydonhang.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepo.findById(id);
    }

    @Override
    public boolean delete(String id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            productRepo.delete(productOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByNameContaining(name);
    }
}
