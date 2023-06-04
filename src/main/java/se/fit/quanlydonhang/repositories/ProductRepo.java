package se.fit.quanlydonhang.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.fit.quanlydonhang.models.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query(value = "SELECT * FROM products  WHERE product_name LIKE %?1%",nativeQuery = true)
    List<Product> findByNameContaining(String name);
}
