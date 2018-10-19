package com.database.remi.controller;

import java.util.Map;

//import java.util.HashMap;

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

     @Autowired
     SalonController controller;
     //controller.salonmap;

    @GetMapping("/salones/{code}/reservas")
    public Page<Reserva> getAllReservesBySalonCode(@PathVariable (value = "code") String code,
                                         Pageable pageable){
        return reservaRepository.findBySalonCodigo(code, pageable);
    }

    @PostMapping("/salones/{code}/reservas")
    public Reserva createReserva(@PathVariable(value = "code") String codigo,
                                 @Valid @RequestBody Reserva reserva){
       return salonRepository.findById(codigo).map(salon -> {
         reserva.setSalon(salon);
         Map<Integer,Boolean> alterno = controller.salones.get(codigo);
         alterno.replace(reserva.getHoraInicial(), true);
         controller.salones.replace(codigo, alterno);
         return reservaRepository.save(reserva);  
       }).orElseThrow(() -> new ResourceNotFoundException("Salon", "codigo" , codigo));  
    }

    @DeleteMapping("/salones/{code}/reservas/{reservaId}")
    public ResponseEntity<?> deleteReserva(@PathVariable (value = "code") String codigo,
                                           @PathVariable(value = "reservaId") Long reservaId){
       
                                           
      if(!salonRepository.existsById(codigo)){
        throw new ResourceNotFoundException("Salon", "codigo" , codigo);
      }else{
           salonRepository.findById(codigo).map(salon -> {
              return salonRepository.save(salon);
          }).orElseThrow(() -> new ResourceNotFoundException("Salon", "codigo" , codigo));  
      }
      
      return reservaRepository.findById(reservaId).map(reserva -> {
        Map<Integer,Boolean> alterno = controller.salones.get(codigo);
         alterno.replace(reserva.getHoraInicial(), false);
         controller.salones.replace(codigo, alterno);
        reservaRepository.delete(reserva);
        return ResponseEntity.ok().build();           
      }).orElseThrow(() -> new ResourceNotFoundException("Reserva", "id" , reservaId));

    }



}
