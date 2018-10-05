package com.database.remi.repository;

import com.database.remi.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalonRepository extends JpaRepository<Salon,String>{
    
}