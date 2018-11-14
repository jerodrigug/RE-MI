package com.database.remi.service;

import com.database.remi.model.Reserva;
import com.database.remi.model.Salon;
import com.database.remi.payload.ReservaRequestMovil;
import com.database.remi.payload.SalonRequest;
import com.database.remi.repository.ReservaRepository;
import com.database.remi.repository.SalonRepository;
import com.database.remi.repository.UsuarioRepository;
import com.database.remi.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class SalonService{
    
    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(SalonService.class);


    public Salon crearSalon(SalonRequest salonRequest){
        if(!salonRepository.existsById(salonRequest.getCodigo())){
            Salon salon = new Salon();
                salon.setCodigo(salonRequest.getCodigo());
                salon.setTipo(salonRequest.getTipo());
                salon.setInstrumento(salonRequest.getInstrumento());
                return salonRepository.save(salon);
        }else{
            return null;
        }
    }

    public List<String> buscarSalones(ReservaRequestMovil movilRequest) {
         List<Salon> salones = salonRepository.findByTipoAndInstrumento(movilRequest.getTipo(), movilRequest.getInstrumento());
         List<String> salonesLibres = new ArrayList<>();
         Date fechaInicial;
         Date fechaFinal;
         if(movilRequest.getDia()=="Mañana"){
            Calendar calendar = Calendar.getInstance();
            calendar.set(0,0,0,movilRequest.getHoraInicial(),0,0);
            calendar.add(Calendar.DATE, 1);
            fechaInicial = calendar.getTime();
            calendar.set(0,0,0,movilRequest.getHoraFinal(),55,0);
             fechaFinal = calendar.getTime();
         }else{
            Calendar calendar = Calendar.getInstance();
            calendar.set(0,0,0,movilRequest.getHoraInicial(),0,0);
             fechaInicial = calendar.getTime();
            calendar.set(0,0,0,movilRequest.getHoraFinal(),55,0);
             fechaFinal = calendar.getTime();
         }

         for (Salon salon : salones) {
          Reserva reserva = reservaRepository.findBySalonOcupado(salon.getCodigo());
           if(salon.getCodigo() != reserva.getSalon().getCodigo()){
                salonesLibres.add(salon.getCodigo());
           }
         }

         if(salonesLibres.size()>0){
            return salonesLibres;
         }else{
             return null;
         }
     }
}
