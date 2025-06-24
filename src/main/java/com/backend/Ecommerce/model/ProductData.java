package com.backend.Ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductData {
    public String id;
    public String name;
    public Integer price;
    public MultipartFile image;
}
