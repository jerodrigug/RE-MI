package com.database.remi.repository;

import java.util.Date;
import java.util.List;
import com.database.remi.model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>{

    @Query("SELECT v FROM Reserva v WHERE v.salon.codigo= :salonId")
    Reserva findBySalonOcupado(@Param("salonId") String salonId/*, 
            @Param("fechaIni") Date fechaIni, @Param("fechaFin") Date fechaFin*/);

    Page<Reserva> findBySalonCodigo(String salonId, Pageable pageable);
    
    //Boolean existsBySalonCode(String codigo);
    //and ((:fechaIni BETWEEN v.fecha.inicial and v.fecha.final) or (:fechaFin between v.fecha.inicial and v.fecha.final))

    Page<Reserva> findByUsuarioCodigo(String userId, Pageable pageable);
}