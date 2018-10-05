package com.database.remi.repository;

import com.database.remi.model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>{
    Page<Reserva> findBySalonCodigo(String salonId, Pageable pageable);
}