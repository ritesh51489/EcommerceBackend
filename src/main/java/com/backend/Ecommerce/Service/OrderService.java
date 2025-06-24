package com.backend.Ecommerce.Service;

import com.backend.Ecommerce.Mapper.OrderMapper;
import com.backend.Ecommerce.Mapper.ProductMapper;
import com.backend.Ecommerce.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class OrderService {

    private final OrderMapper orderMapper;
    OrderService(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    @Transactional
    public void addOrder(OrderInputBody orderInputBody) {
        List<Order> orders=orderInputBody.getOrders();
        OrderModel orderModel= OrderModel.builder().customerId(orderInputBody.getUserId()).build();
        orderMapper.insertOrder(orderModel);
        int orderId= orderModel.getOrderId();
        int amount=0;
        for(Order order:orders){
            order.setOrderId(orderId);
            amount+=order.getPrice()*order.getQuantity();
            orderMapper.addOrderProducts(order);
        }
        orderMapper.addTotalAmount(orderId,amount);
    }

    public List<Orderbook> getOrders() {
        return orderMapper.getOrders();
    }
    public List<Orderbook> getOrdersByUserId(String userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

}
