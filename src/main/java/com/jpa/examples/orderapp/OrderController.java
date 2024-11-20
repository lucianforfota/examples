package com.jpa.examples.orderapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders =  orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
       /*try {
           Order order= orderService.findById(id);
           return ResponseEntity.ok(order);
       } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
       }*/
        Order order= orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        Order savedOrder = orderService.addOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id){
        Order updatedOrder = orderService.updateOrder(order, id);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/between")
    public List<Order> findAllBetween(@RequestParam String startDate, @RequestParam String endDate ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

       try {
           return orderService.findAllBetween(start, end);
       }catch(Exception e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
       }
    }


}
