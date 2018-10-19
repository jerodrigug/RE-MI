package com.database.remi.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest{
    
    @NotBlank
    private String correo;

    @NotBlank
    private String contrasena;


    //Getters
    public String getCorreo(){
        return correo;
    }

    public String getContrasena(){
        return contrasena;
    }

    //Setters
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
}