package com.database.remi.payload;

import javax.validation.constraints.*;

public class SignUpRequest{

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long codigo;

    @NotBlank
    @Size(max = 50)
    private String nombre;

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    @Size(max = 20)
    private String especializacion;

    @NotBlank
    @Size(min=8)
    private String contrasena;

    //Getters
    public Long getCodigo(){
        return codigo;
    }

    public  String getNombre(){
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

    //Setters
    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setEspecializacion(String especializacion){
        this.especializacion = especializacion;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

}