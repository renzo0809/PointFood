package com.example.repository;

import com.example.entity.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DueñoRepository extends JpaRepository<Dueño,Long> {
}
