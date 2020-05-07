package com.example.repository;

import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findOrderById(Long id);

    @Query("UPDATE Order o SET o.state=?2 WHERE o.id=?1")
    void updateState(Long id, String state);

    @Query("SELECT o FROM Order o WHERE o.state=?1")
    List<Order> findOrderByState(String state);
}
