package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping("/phone")
    public List<Phone> index(){
        return phoneRepository.findAll();
    }

    @GetMapping("/phone/search")
    public List<Phone> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return phoneRepository.findByMakeContainingOrModelContaining(searchTerm, searchTerm);
    }

}