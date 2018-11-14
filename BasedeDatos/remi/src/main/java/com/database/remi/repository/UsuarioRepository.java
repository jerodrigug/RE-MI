package com.database.remi.repository;

import java.util.Optional;

import com.database.remi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    Optional<Usuario> findByCodigo(Long codigo);
    
    Optional<Usuario> findByCorreo(String correo);

    Optional <Usuario> findByNombre(String nombre);

    //Optional<Usuario> findByCodigo(Integer codigo);

    Boolean existsByNombre(String nombre);

    Boolean existsByCorreo(String correo);

}