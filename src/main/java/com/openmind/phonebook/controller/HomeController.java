package com.openmind.phonebook.controller;

import com.openmind.phonebook.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LocationRepository locationRepository;

    public HomeController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("locations", locationRepository.findAll());
        return "home";
    }
}
