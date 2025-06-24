package com.backend.Ecommerce.Mapper;

import com.backend.Ecommerce.model.Order;
import com.backend.Ecommerce.model.OrderModel;
import com.backend.Ecommerce.model.Orderbook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insertOrder(OrderModel orderModel);
    void addOrderProducts(Order order);
    List<Orderbook> getOrders();
    List<Orderbook> getOrdersByUserId(String userId);
    void addTotalAmount(@RequestParam("orderId") int orderId,@RequestParam("amount") int amount);
}
