package com.jpa.examples;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderStatus(Status status);

    List<Order> findAllByOrderDateBetween(LocalDate start, LocalDate end);

    List<Order> findAllByProductTypeAndOrderDateAfter(String productType, LocalDate after);

    //@Query(value = "SELECT o FROM Order WHERE o.orderStatus = :orderStatus", nativeQuery=false)
    //List<Order> findAllOrdersByOrderStatus2 (@Param("orderStatus") Status orderStatus);

}







