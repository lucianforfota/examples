package com.jpa.examples.orderapp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("order not found"));
    }

    @Transactional
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Order order, Long id){
        Order orderToBeUpdated = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("order not found"));
        orderToBeUpdated.setOrderStatus(order.getOrderStatus());
        orderToBeUpdated.setOrderDate(order.getOrderDate());
        orderToBeUpdated.setProductType(order.getProductType());
        return orderRepository.save(orderToBeUpdated);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> findAllBetween(LocalDate start, LocalDate end) throws Exception {
        List<Order> orders = orderRepository.findAllByOrderDateBetween(start, end);
        if (orders.isEmpty()) {
            throw new Exception("nu au fost gasite order intre datele");
        }
        return orders;
    }
}


