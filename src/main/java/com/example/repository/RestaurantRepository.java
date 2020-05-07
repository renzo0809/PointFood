package com.example.repository;

import com.example.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r JOIN FETCH r.restaurantOwner ro WHERE ro.id=?1")
    List<Restaurant> findRestaurantsByRestaurantOwner(Long id);
}
