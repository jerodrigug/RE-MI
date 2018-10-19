package com.database.remi.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import com.database.remi.exception.AppException;
import com.database.remi.model.Rol;
import com.database.remi.model.RolName;
import com.database.remi.model.Usuario;
import com.database.remi.payload.ApiResponse;
import com.database.remi.payload.JwtAuthenticationResponse;
import com.database.remi.payload.LoginRequest;
import com.database.remi.payload.SignUpRequest;
import com.database.remi.repository.RolRepository;
import com.database.remi.repository.UsuarioRepository;
import com.database.remi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("app/auth")
public class AuthController{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    

    @PostMapping("/singnin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getCorreo(),
                        loginRequest.getContrasena()
                )
        );
        System.out.println("Authentication"+ loginRequest.getCorreo() + loginRequest.getContrasena());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Se guarda la authentication en el contexto");
        String jwt = tokenProvider.generateToken(authentication);
        System.out.println("Se genera el token");
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(usuarioRepository.existsById(signUpRequest.getCodigo())) {
            return new ResponseEntity(new ApiResponse(false, "Codigo is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(usuarioRepository.existsByCorreo(signUpRequest.getCorreo())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Usuario usuario = new Usuario(signUpRequest.getCodigo(), signUpRequest.getNombre(),
                signUpRequest.getCorreo(), signUpRequest.getEspecializacion(), signUpRequest.getContrasena());
        
        Rol userRol = rolRepository.findByName(RolName.ROL_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        
        usuario.setRoles(Collections.singleton(userRol));

        Usuario result = usuarioRepository.save(usuario);
        
         URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/app/usuarios/{codigo}")
                .buildAndExpand(result.getCodigo()).toUri();
                

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}


