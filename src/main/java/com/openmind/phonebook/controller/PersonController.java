package com.openmind.phonebook.controller;

import com.openmind.phonebook.domain.Person;
import com.openmind.phonebook.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person/{id}")
    public String person(@PathVariable("id") String id, ModelMap model) {
        Person employee = repository.findOne(id);
        Person manager = repository.findOne(employee.getManagerId());

        model.addAttribute("person", employee);
        model.addAttribute("manager", manager);

        if(manager != null) {
            model.addAttribute("cowokers", repository.findByManagerId(manager.getId()));
        }

        return "/modal/person :: modalContents";
    }

    @GetMapping("/people/{id}")
    public String people(@PathVariable("id") String id) {
        Person employee = repository.findOne(id);

        System.out.println(employee.getFullName());

        return "/location/PA";
    }
}
