package com.database.remi.repository;

import com.database.remi.model.Rol;
import com.database.remi.model.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(RolName rolName);
}