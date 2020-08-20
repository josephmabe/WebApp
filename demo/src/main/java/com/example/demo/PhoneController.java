package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping("/phones")
    public List<Phone> index(){
        return phoneRepository.findAll();
    }

    @GetMapping("/makesAndModels/{searchTerm}")
    public List<Phone> searchMakesAndModels(@PathVariable String searchTerm){
        return phoneRepository.findByMakeOrModel(searchTerm);
    }

}