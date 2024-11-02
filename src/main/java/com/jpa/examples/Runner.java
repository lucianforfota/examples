package com.jpa.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {

    private OrderRepository orderRepository;

    @Autowired
    public Runner(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order("lactate", LocalDate.of(2024,10,30),Status.PENDING,"progress");
        Order order2 = new Order("lactate", LocalDate.of(2024,10,30),Status.PENDING,"progress");
        orderRepository.save(order);
        orderRepository.save(order2);
        Order foundOrder = orderRepository.findById(1L).orElseThrow(() -> new Exception("order not found"));
        System.out.println(foundOrder);
        order2.setOrderStatus(Status.SHIPPED);
        orderRepository.save(order2);
        orderRepository.delete(order2);
        orderRepository.findAllByOrderStatus(Status.PENDING);



    }
}
