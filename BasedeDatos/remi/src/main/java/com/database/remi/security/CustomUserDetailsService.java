package com.database.remi.security;

import com.database.remi.model.Usuario;
import com.database.remi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired 
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException{
         // Let people login with email
        Usuario usuario = usuarioRepository.findByCorreo(correo).orElseThrow(() -> 
                         new UsernameNotFoundException("Usuario no encontrado con este correo"));     
    

    return UserPrincipal.create(usuario);
    }

    //This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long codigo){
        Usuario usuario = usuarioRepository.findByCodigo(codigo).orElseThrow(
            () -> new UsernameNotFoundException("Usuario no encontrado con el código:" + codigo)
        );

        return UserPrincipal.create(usuario);
    }
}