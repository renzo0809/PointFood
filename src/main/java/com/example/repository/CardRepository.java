package com.example.repository;

import com.example.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT ca FROM Card ca JOIN FETCH ca.client cl WHERE cl.id=?1")
    Card findCardByClientId(Long id);
}
