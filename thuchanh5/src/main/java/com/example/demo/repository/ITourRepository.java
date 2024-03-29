package com.example.demo.repository;

import com.example.demo.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Long> {
}
