package com.database.remi.controller;

import java.util.Map;

//import java.util.HashMap;

import javax.validation.Valid;

import com.database.remi.exception.ResourceNotFoundException;
import com.database.remi.model.Reserva;
import com.database.remi.model.Usuario;
import com.database.remi.repository.ReservaRepository;
import com.database.remi.repository.SalonRepository;
import com.database.remi.repository.UsuarioRepository;
import com.database.remi.service.SalonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;     
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
public class ReservaController{
    @Autowired 
     private ReservaRepository reservaRepository;

    @Autowired
     private SalonRepository salonRepository;

     @Autowired 
     UsuarioRepository usuarioRepository;

     @Autowired
     AuthController controller;
     

    @GetMapping("/salones/{code}/reservas")
    public Page<Reserva> getAllReservesBySalonCode(@PathVariable (value = "code") String code,Pageable pageable){
        return reservaRepository.findBySalonCodigo(code, pageable);
    }

    @PostMapping("/salones/{code}/reservas")
    public Reserva createReserva(@PathVariable(value = "code") String code,
                                 @Valid @RequestBody Reserva reserva) throws UsernameNotFoundException{
         return salonRepository.findById(code).map(salon -> {
          reserva.setSalon(salonRepository.findByCodigo(code));
          Usuario usuario = usuarioRepository.findByCodigo(controller.getCodigoUsuario()).orElseThrow(()->
                         new UsernameNotFoundException("Usuario no encontrado con este correo"));  
          reserva.setUsuario(usuario);
         return reservaRepository.save(reserva);  
       }).orElseThrow(() -> new ResourceNotFoundException("Salon", "codigo" , code));  
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
       // Map<Integer,Boolean> alterno = controller.salones.get(codigo);
         //alterno.replace(reserva.getHoraInicial(), false);
         //controller.salones.replace(codigo, alterno);
        reservaRepository.delete(reserva);
        return ResponseEntity.ok().build();           
      }).orElseThrow(() -> new ResourceNotFoundException("Reserva", "id" , reservaId));

    }



}
