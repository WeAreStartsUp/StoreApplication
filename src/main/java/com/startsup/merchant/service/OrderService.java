package com.startsup.merchant.service;

import com.startsup.merchant.database.repository.OrderItemsRepository;
import com.startsup.merchant.database.repository.OrdersRepository;
import com.startsup.merchant.entities.Order;
import com.startsup.merchant.entities.OrderItems;
import com.startsup.merchant.entities.OrderItemsId;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderService(OrdersRepository ordersRepository, OrderItemsRepository orderItemsRepository) {
        this.ordersRepository = ordersRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    public List<Order> getAllOrders() {
        List<Order> orders;
        try {
            orders = ordersRepository.findAll();
        } catch (Exception e) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    public Optional<Order> getOrderFromId(int id) {
        Optional<Order> order;
        try {
            order = ordersRepository.findById(id);
        } catch (Exception e) {
            order = Optional.empty();
        }
        return order;
    }

    public Optional<Order> updateOrder(Order order) {
        try {
            order = ordersRepository.save(order);
            int id = order.getId();
            List<OrderItems> orderItems = order.getListOfOrderItems();
            orderItems = orderItems.stream().map(item -> {
//                int itemId = item.getItems().getId();
//                item.setItemId(itemId);
                item.setOrderId(id);
                return item;}).collect(Collectors.toList());
            orderItemsRepository.saveAll(orderItems);
            return Optional.of(order);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Order> getAllOrdersByMerchantId(int merchantId) {
        List<Order> orders = ordersRepository.findOrdersByMerchantId(merchantId);
        return orders;
    }
}
