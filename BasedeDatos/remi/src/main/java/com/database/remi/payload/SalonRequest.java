package com.database.remi.payload;

import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


public class SalonRequest{

    @Id
    @Size(max = 6)
    private String codigo;

    @NotNull
    @Size(max = 8)
    private String tipo;

    @NotNull
    @Size(max = 30)
    private String instrumento;

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getInstrumento(){
        return instrumento;
    }

    public void setInstrumento(String instrumento){
        this.instrumento  = instrumento;
    }

}