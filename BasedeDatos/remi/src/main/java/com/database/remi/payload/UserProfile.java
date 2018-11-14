package com.database.remi.payload;



public class UserProfile{

    private Long codigo;
    private String nombre;
    private String correo;
    private String especializacion;
    private Long cantidadReservas;

    private UserProfile(Long codigo, String nombre, String correo, String especializacion, Long cantidadReservas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.especializacion = especializacion;
        this.cantidadReservas = cantidadReservas;
    }

    public Long getCodigo(){
        return codigo;
    }

    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getEspecializacion(){
        return especializacion;
    }

    public void setEspecializacion(String especializacion){
        this.especializacion = especializacion;
    }

    public Long getCantidadReservas(){
        return cantidadReservas;
    }

    public void setCantidadReservas(Long cantidadReservas){
        this.cantidadReservas = cantidadReservas;
    }


}