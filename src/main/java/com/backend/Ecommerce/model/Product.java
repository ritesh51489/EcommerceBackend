package com.backend.Ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    public int id;
    public String name;
    public Integer price;
    public String image;
    public String company;
    public String category;

}
