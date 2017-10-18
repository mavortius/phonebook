package com.openmind.phonebook.controller;

import com.openmind.phonebook.repository.LocationRepository;
import com.openmind.phonebook.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LocationController {

    private final PersonRepository personRepository;
    private final LocationRepository locationRepository;

    public LocationController(PersonRepository personRepository, LocationRepository locationRepository) {
        this.personRepository = personRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/location/{id}")
    public String location(@PathVariable("id") String id, ModelMap model) {
        model.addAttribute("people", personRepository.findByLocationId(id));
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("selectedLocation", locationRepository.findOne(id));

        return "location";
    }
}
