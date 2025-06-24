package com.backend.Ecommerce.Mapper;

import com.backend.Ecommerce.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

     void addProduct(Product product);
     List<Product> getProducts() ;
     void updateProduct(Product product);

}
