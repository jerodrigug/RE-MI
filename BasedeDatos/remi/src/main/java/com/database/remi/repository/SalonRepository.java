package com.database.remi.repository;


import java.util.List;
import com.database.remi.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SalonRepository extends JpaRepository<Salon,String>{
    
    @Query("SELECT v FROM Salon v WHERE v.tipo = :tipo and v.instrumento = :instrumento ")
    List<Salon> findBySalonTipoInstrumento(@Param("tipo") String tipo, @Param("instrumento") String instrumento);

    Salon findByCodigo(String codigo);

    List<Salon> findByTipoAndInstrumento(String tipo,String instrumento);

}