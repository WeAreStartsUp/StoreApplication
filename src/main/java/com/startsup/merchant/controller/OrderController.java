package com.startsup.merchant.controller;

import com.startsup.merchant.entities.Items;
import com.startsup.merchant.entities.Order;
import com.startsup.merchant.service.ItemService;
import com.startsup.merchant.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public ResponseEntity<List<Order>> fetchAllOrders() {
        logger.info("Request Received");
        List<Order> orders = orderService.getAllOrders();
        logger.info("Response={}", orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Object> fetchOrderById(@PathVariable int id) {
        logger.info("Request Received");
        Optional<Order> order = orderService.getOrderFromId(id);
        logger.info("Response={}", order);
        return order.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/orders/merchant/{merchant_id}")
    public ResponseEntity<List<Order>> fetchAllOrdersByMerchantId(@PathVariable int merchant_id) {
        logger.info("Request Received");
        List<Order> items = orderService.getAllOrdersByMerchantId(merchant_id);
        logger.info("Response={}", items);
        return items.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(items);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrUpdateOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(order).get());
    }


}
