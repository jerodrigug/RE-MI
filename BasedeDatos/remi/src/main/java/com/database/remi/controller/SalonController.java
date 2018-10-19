package com.database.remi.controller;

import com.database.remi.exception.ResourceNotFoundException;
import com.database.remi.model.Salon;
//import com.database.remi.model.SalonMap;
import com.database.remi.model.Horas;
import com.database.remi.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

@RestController
public class SalonController {
    Map<String, Map<Integer,Boolean>> salones = new HashMap<String, Map<Integer, Boolean>>();

    public Map<String, Map<Integer,Boolean>> getSalones(){
        return salones;
    }

    public void createSalonMap(String code){
        Horas horas = new Horas();
        salones.put(code, horas.createHorario());
    }

    @Autowired
    SalonRepository salonrepository;

    @GetMapping("/salones")
     public Page<Salon> getAllSalones(Pageable pageable){
            return salonrepository.findAll(pageable);
     }

     @PostMapping("/salones")
        public Salon createSalon(@Valid @RequestBody Salon salon){
            createSalonMap(salon.getCodigo());
            return salonrepository.save(salon);
     }

     @GetMapping("/salones/SalonMap")
      public Map<String, Map<Integer,Boolean>> getSalonMap(){
        return salones;
     }


     @GetMapping("/salones/{code}")
     public Salon getSalonBy(@PathVariable(value = "code") String codigo){
        return salonrepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
     }

     @DeleteMapping("salones/{code}")
     public ResponseEntity<?> deletePost(@PathVariable(value = "code") String codigo) {
        return salonrepository.findById(codigo).map(salon -> {
            salonrepository.delete(salon);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
    }

    @PutMapping("/salones/{code}")
    public Salon updateSalon(@PathVariable(value = "code") String codigo,
                              @Valid @RequestBody  Salon salonRequest){
        return salonrepository.findById(codigo).map(salon -> {
            salon.setCodigo(salonRequest.getCodigo());
            salon.setTipo(salonRequest.getTipo());
            salon.setInstrumento(salonRequest.getInstrumento());
            return salonrepository.save(salon);
        }).orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
    }

    }