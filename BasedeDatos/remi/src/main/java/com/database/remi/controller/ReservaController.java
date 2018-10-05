package com.database.remi.controller;

import javax.validation.Valid;

import com.database.remi.exception.ResourceNotFoundException;
import com.database.remi.model.Reserva;
import com.database.remi.repository.ReservaRepository;
import com.database.remi.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;     
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
public class ReservaController{
    @Autowired 
     private ReservaRepository reservaRepository;

    @Autowired
     private SalonRepository salonRepository;

    @GetMapping("/salones/{code}/reservas")
    public Page<Reserva> getAllReservesBySalonCode(@PathVariable (value = "code") String code,
                                         Pageable pageable){
        return reservaRepository.findBySalonCodigo(code, pageable);
    }

    @PostMapping("/salones/{code}/reservas")
    public Reserva createReserva(@PathVariable(value = "code") String code,
                                 @Valid @RequestBody Reserva reserva){
       return salonRepository.findById(code).map(salon -> {
         salon.setEstado("Ocupado");  
         reserva.setSalon(salon);
         return reservaRepository.save(reserva);  
       }).orElseThrow(() -> new ResourceNotFoundException("Salon code" + code + "not found"));  
    }

    @DeleteMapping("/salones/{code}/reservas/{reservaId}")
    public ResponseEntity<?> deleteReserva(@PathVariable (value = "code") String code,
                                           @PathVariable(value = "reservaId") Long reservaId){
       
                                           
      if(!salonRepository.existsById(code)){
        throw new ResourceNotFoundException("Salon code" + code + "not found");
      }else{
           salonRepository.findById(code).map(salon -> {
              salon.setEstado("Disponible");
              return salonRepository.save(salon);
          }).orElseThrow(() -> new ResourceNotFoundException("Salon code" + code + "not found"));  
      }
      
      return reservaRepository.findById(reservaId).map(reserva -> {
        reservaRepository.delete(reserva);
        return ResponseEntity.ok().build();           
      }).orElseThrow(() -> new ResourceNotFoundException("ReservaId" + reservaId + "not found"));

    }



}
