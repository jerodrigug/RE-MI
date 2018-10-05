package com.database.remi.controller;

import com.database.remi.exception.ResourceNotFoundException;
import com.database.remi.model.Salon;
import com.database.remi.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class SalonController {
    @Autowired
    SalonRepository salonrepository;

    @GetMapping("/salones")
     public Page<Salon> getAllSalones(Pageable pageable){
            return salonrepository.findAll(pageable);
     }

     @PostMapping("/salones")
        public Salon createSalon(@Valid @RequestBody Salon salon){
            return salonrepository.save(salon);
        }

     @GetMapping("/salones/{code}")
     public Salon getSalonBy(@PathVariable(value = "code") String code){
        return salonrepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Code salon " + code + " not found"));
     }
    
}