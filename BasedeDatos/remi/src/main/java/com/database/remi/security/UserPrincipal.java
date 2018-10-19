package com.database.remi.security;

import com.database.remi.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserPrincipal implements UserDetails{
    private static final long serialVersionUID = 1L;

    private Long codigo;

    private String nombre;

    @JsonIgnore
    private String correo;

    private String especializacion;

    @JsonIgnore
    private String contrasena;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long codigo, String nombre, String correo, String especializacion, String contrasena, Collection<? extends GrantedAuthority> authorities){
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.especializacion = especializacion;
        this.contrasena = contrasena;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Usuario usuario){
        List<GrantedAuthority>authorities = usuario.getRoles().stream().map(rol ->
                  new SimpleGrantedAuthority(rol.getName().name())
                  ).collect(Collectors.toList());

        return new UserPrincipal(
            usuario.getCodigo(),
            usuario.getNombre(),
            usuario.getCorreo(),
            usuario.getEspecializacion(),
            usuario.getContrasena(),
            authorities
        );
    }


    //Getters
    public Long getCodigo(){
        return codigo;
    }

    public String getUsername(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getEspecializacion(){
        return especializacion;
    }

    @Override
    public String getPassword(){
        return contrasena;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo);
    }


    
}
