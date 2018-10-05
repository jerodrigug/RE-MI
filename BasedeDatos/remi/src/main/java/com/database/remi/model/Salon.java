package com.database.remi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name= "salones")
public class Salon{

    @Id
    @Size(max = 6)
    private String codigo;

    @NotNull
    @Size(max = 8)
    private String tipo;

    @NotNull
    @Size(max = 30)
    private String instrumento;

    @NotNull
    @Size(max = 100)
    private String descripcion;

    @NotNull
    @Size(max = 10)
    private String estado; 

    //Getters
    public String getCodigo(){
        return codigo;
    }
    public String getTipo(){
        return tipo;
    }
    public String getInstrumento(){
        return instrumento;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getEstado(){
        return estado;
    }

    //Setters
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setInstrumento(String instrumento){
        this.instrumento = instrumento;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

}