package com.jpa.examples.orderapp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository =orderRepository;
    }

    @Transactional
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Transactional
    public Order findById(Long id) throws Exception{
        return orderRepository.findById(id).orElseThrow(()->new Exception("order not found"));
    }

    @Transactional
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Order order, Long id) throws Exception{
        Order orderToBeUpdated = orderRepository.findById(id).orElseThrow(()->new Exception("order not found"));
        orderToBeUpdated.setOrderStatus(order.getOrderStatus());
        orderToBeUpdated.setOrderDate(order.getOrderDate());
        orderToBeUpdated.setProductType(order.getProductType());
        return orderRepository.save(orderToBeUpdated);
    }

    @Transactional
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
