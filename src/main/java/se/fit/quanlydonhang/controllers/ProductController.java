package se.fit.quanlydonhang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import se.fit.quanlydonhang.models.Manufacturer;
import se.fit.quanlydonhang.models.Product;
import se.fit.quanlydonhang.services.ManufacturerService;
import se.fit.quanlydonhang.services.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ManufacturerService manufacturerService;

    public ProductController (ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping({ "","/list"})
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productService.findAll());
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    @GetMapping( "/show-add-form")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        modelAndView.setViewName("add_product");
        return modelAndView;
    }

    @PostMapping( "/saveProduct")
    public ModelAndView addProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        Product pro = product;
        productService.saveProduct(product);
        modelAndView.addObject("products", productService.findAll());
        modelAndView.setViewName("redirect:/products/list");
        return modelAndView;
    }

    @GetMapping( "/show-edit-form")
    public ModelAndView showEditForm(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Product> product1 = productService.findById(id);
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("manufacturers", manufacturerService.findAll());
        modelAndView.setViewName("edit_product");
        return modelAndView;
    }

    @GetMapping( "/delete")
    public ModelAndView deleteProduct(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.deleteProduct(product.get());
        }
        modelAndView.addObject("products", productService.findAll());
        modelAndView.setViewName("redirect:/products/list");
        return modelAndView;
    }

    @GetMapping( "/search")
    public ModelAndView searchProduct(@RequestParam("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productService.findByName(keyword));
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    @GetMapping( "/show-details")
    public ModelAndView showDetails(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            modelAndView.addObject("product", product.get());
            modelAndView.setViewName("product_details");
        }
        return modelAndView;
    }
}
