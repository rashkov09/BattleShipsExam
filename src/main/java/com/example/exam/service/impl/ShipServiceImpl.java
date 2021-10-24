package com.example.exam.service.impl;

import com.example.exam.model.entity.Ship;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.view.ShipViewModel;
import com.example.exam.repository.ShipRepository;
import com.example.exam.sec.CurrentUser;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    public final ShipRepository shipRepository;
    public final ModelMapper modelMapper;
    public final CurrentUser currentUser;
    public final UserService userService;
    public final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel,Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findCategoryByName(shipServiceModel.getCategory()));
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findAllByUserId(Long id) {
        return shipRepository
                .findAllByUserId(id)
                .stream()
                .map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAll() {
        return shipRepository.findAll().stream().map(ship -> modelMapper.map(ship,ShipViewModel.class)).collect(Collectors.toList());
    }
}
