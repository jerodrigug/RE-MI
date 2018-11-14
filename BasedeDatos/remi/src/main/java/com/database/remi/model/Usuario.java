package com.database.remi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "correo"
    })
})
public class Usuario{
    @Id
    @Digits(integer = 12, fraction = 0)
    @NotNull
    private Long codigo;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @NotNull
    @Email
    @NaturalId
    private String correo;

    @NotNull
    @Size(max=20)
    private String especializacion;

    @NotNull 
    @Size(min = 8)
    private String contrasena;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_usuario",
            joinColumns = @JoinColumn(name = "cod_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();


    public Usuario(){
        
    }
    public Usuario(Long codigo,String nombre, String correo, String especializacion, String contrasena){
        this.codigo=codigo;
        this.nombre=nombre;
        this.correo=correo;
        this.especializacion=especializacion;
        this.contrasena=contrasena;
    }


    //Getters
    public Long getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getEspecializacion(){
        return especializacion;
    }

    public String getContrasena(){
        return contrasena;
    }

    public Set<Rol> getRoles(){
        return roles;
    }

    //Setters
    public void setCodigo(Long codigo){
        this.codigo=codigo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public void setEspecializacion(String especializacion){
        this.especializacion=especializacion;
    }

    public void setContrasena(String contrasena){
         this.contrasena=contrasena;   
    }

    public void setRoles(Set<Rol> roles){
        this.roles=roles;
    }

	public Usuario orElseThrow(Object object) {
		return null;
	}
}