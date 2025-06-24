package com.backend.Ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Orderbook {
    String name;
    Integer price;
    String image;
    int quantity;
    int amount;
    String date;
    String user;
    String orderId;
}
