package com.example.exam.web.controller;

import com.example.exam.model.entity.User;
import com.example.exam.model.view.ShipViewModel;
import com.example.exam.sec.CurrentUser;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController{
    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if (currentUser.getId() == null){
            return "index";
        }

        List<ShipViewModel> ships = shipService.findAllByUserId(currentUser.getId());
        User onlineUser  = userService.findById(currentUser.getId());
        if (onlineUser.getShips().size() > 0){
            model.addAttribute("onlineUser",onlineUser);
        }

        List<ShipViewModel> otherShips = shipService.findAll().stream()
                .filter(ship-> !ship.getUser().getUsername().equals(currentUser.getUsername())).collect(Collectors.toList());

        model.addAttribute("ships",ships);
        model.addAttribute("otherShips",otherShips);
        return "home";
    }


}
