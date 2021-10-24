package com.example.exam.repository;

import com.example.exam.model.entity.Ship;
import com.example.exam.model.view.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findAllByUserId(Long id);
}
