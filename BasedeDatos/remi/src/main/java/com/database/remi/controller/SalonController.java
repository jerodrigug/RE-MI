package com.database.remi.controller;

import com.database.remi.exception.ResourceNotFoundException;
import com.database.remi.model.Salon;
import com.database.remi.payload.ApiResponse;
import com.database.remi.payload.ReservaRequestMovil;
import com.database.remi.payload.SalonRequest;
import com.database.remi.repository.SalonRepository;
import com.database.remi.repository.UsuarioRepository;
import com.database.remi.service.SalonService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/salones")
public class SalonController {
    
    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SalonService salonService;

    @Autowired
    private AuthController authController;

    private static final Logger logger = LoggerFactory.getLogger(SalonController.class);

    @GetMapping
     public Page<Salon> getAllSalones(Pageable pageable){
            return salonRepository.findAll(pageable);
     }


    //@GetMapping
    //public Page<Salon> getSalonesReservar(@Valid @RequestBody ReservaRequestMovil requestMovil){
     //   List<String> sinReservar = salonService.buscarSalones(requestMovil);
    //}

     @PostMapping
     //@PreAuthorize("hasRole('ROL_USER')")
        public ResponseEntity<?> createSalon(@Valid @RequestBody SalonRequest salonRequest){
             Salon salon = salonService.crearSalon(salonRequest);
            
             if(salon!=null){
                URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{salonId}")
                .buildAndExpand(salon.getCodigo()).toUri();
                return ResponseEntity.created(location)
             .body(new ApiResponse(true, "Salon creado satisfactoriamente"));
             }else{
                 return ResponseEntity.ok(new ApiResponse(false, "El salon ya existe"));
             }
       }

     @GetMapping("/salones/{code}")
     public Salon getSalonBy(@PathVariable(value = "code") String codigo){
        return salonRepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
     }

     @DeleteMapping("salones/{code}")
     public ResponseEntity<?> deletePost(@PathVariable(value = "code") String codigo) {
        return salonRepository.findById(codigo).map(salon -> {
            salonRepository.delete(salon);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
    }

    @PutMapping("/salones/{code}")
    public Salon updateSalon(@PathVariable(value = "code") String codigo,
                              @Valid @RequestBody  Salon salonRequest){
        return salonRepository.findById(codigo).map(salon -> {
            salon.setCodigo(salonRequest.getCodigo());
            salon.setTipo(salonRequest.getTipo());
            salon.setInstrumento(salonRequest.getInstrumento());
            return salonRepository.save(salon);
        }).orElseThrow(() -> new ResourceNotFoundException("Salon","codigo",codigo));
    }

    }