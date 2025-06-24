package com.backend.Ecommerce.Service;

import com.backend.Ecommerce.Mapper.ProductMapper;
import com.backend.Ecommerce.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService {

    private static final String UPLOAD_DIR = "E:/ecom/Ecommerce/Ecommerce/src/main/resources/static/images/";
    private final ProductMapper productMapper;

    ProductService(ProductMapper productMapper) {
        this.productMapper=productMapper;
    }

    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

    public void updateProduct(int id,
                              String name,
                              Integer price,
                              String company,
                              String category,
                              MultipartFile image) {
        try{
            Product product = new Product();
            if(!image.isEmpty()){
//                String filename = System.currentTimeMillis() + "_" + image.getOriginalFilename();
//                Path filePath = Paths.get(UPLOAD_DIR + filename);
                String url="";
                // Save file in folder
//                Files.createDirectories(filePath.getParent());
//                Files.write(filePath, image.getBytes());
                product.setImage(url);
            }
            // Save product details in DB
            product.setName(name);
            product.setPrice(price);
            product.setCategory(category);
            product.setCompany(company);
            product.setId(id);
            productMapper.updateProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void addProduct(
                              String name,
                              Integer price,
                              String company,
                              String category,
                              MultipartFile image) {
        try{
            Product product = new Product();
            if(!image.isEmpty()){
//                String filename = System.currentTimeMillis() + "_" + image.getOriginalFilename();
//                Path filePath = Paths.get(UPLOAD_DIR + filename);
//                String url=awsS3Service.uploadFile(image);
                String url="";
                // Save file in folder
//                Files.createDirectories(filePath.getParent());
//                Files.write(filePath, image.getBytes());
                product.setImage(url);
            }
            product.setName(name);
            product.setPrice(price);
            product.setCategory(category);
            product.setCompany(company);
            productMapper.addProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
