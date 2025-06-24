package com.backend.Ecommerce.Controller;

import com.backend.Ecommerce.Service.OrderService;
import com.backend.Ecommerce.Service.ProductService;
import com.backend.Ecommerce.model.Order;
import com.backend.Ecommerce.model.OrderInputBody;
import com.backend.Ecommerce.model.Orderbook;
import com.backend.Ecommerce.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderConroller {

    OrderService orderService;

    OrderConroller(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderInputBody orderInputBody) {
        orderService.addOrder(orderInputBody);
    }

    @GetMapping("/get")
    public List<Orderbook> getOrders() {
        return orderService.getOrders();
    }
    @GetMapping("/getOrdersByUserId")
    public List<Orderbook> getOrdersByUserId(@RequestParam String userId) {
        return orderService.getOrdersByUserId(userId);
    }

}
