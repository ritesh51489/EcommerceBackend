package com.backend.Ecommerce.Controller;

import com.backend.Ecommerce.Service.ProductService;
import com.backend.Ecommerce.model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        List<Product> products=productService.getProducts();
        return products;
    }

    @PostMapping("/update")
    public void updateProduct(      @RequestParam("id") int id,
                                    @RequestParam("name") String name,
                                    @RequestParam("price") Integer price,
                                    @RequestParam("company") String company,
                                    @RequestParam("category") String category,
                                    @RequestParam(value = "image",required = false) MultipartFile image) {
        productService.updateProduct(id,name,price,company,category,image);
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam("name") String name,
                           @RequestParam("price") Integer price,
                           @RequestParam("company") String company,
                           @RequestParam("category") String category,
                           @RequestParam(value = "image",required = false) MultipartFile image) {
        productService.addProduct(name,price,company,category,image);
    }

}
