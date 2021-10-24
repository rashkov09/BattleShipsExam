package com.example.exam.service;

import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel map);

    List<ShipViewModel> findAllByUserId(Long id);

    List<ShipViewModel> findAll();
}
