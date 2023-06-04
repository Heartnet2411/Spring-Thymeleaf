package se.fit.quanlydonhang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.fit.quanlydonhang.models.Manufacturer;
import se.fit.quanlydonhang.models.Product;
import se.fit.quanlydonhang.repositories.ManufacturerRepo;
import se.fit.quanlydonhang.repositories.ProductRepo;
import se.fit.quanlydonhang.services.ManufacturerService;
import se.fit.quanlydonhang.services.ProductService;
import se.fit.quanlydonhang.services.impl.ManufacturerServiceImpl;
import se.fit.quanlydonhang.services.impl.ProductServiceImpl;

@SpringBootApplication
public class QuanLyDonHangApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLyDonHangApplication.class, args);
    }

//    @Bean
    public CommandLineRunner run(ProductRepo productRepo, ManufacturerRepo manufacturerRepo) throws Exception {
        return args -> {
            Manufacturer manufacturer = new Manufacturer("111", "Apple", "USA", "abc@mail", "0123456789", "www.apple.com");
            Product product = new Product("111", "Iphone 12", "Purple" );
            product.setManID(manufacturer);

            ManufacturerService manufacturerService = new ManufacturerServiceImpl(manufacturerRepo);
            manufacturerService.saveManufacturer(manufacturer);

            ProductService productService = new ProductServiceImpl(productRepo);
            productService.saveProduct(product);
        };
    }
}
