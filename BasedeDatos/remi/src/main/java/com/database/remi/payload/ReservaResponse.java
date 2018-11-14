package com.database.remi.payload;

import java.util.Date;

public class ReservaResponse {

    private Long id;
    private String dia;
    private Integer horaInicial;
    private Integer horaFinal;
    private Date createdAt;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDia(){
        return dia;
    }

    public void setDia(String dia){
        this.dia = dia;
    }

    public Integer getHoraInicial(){
        return horaInicial;
    }

    public void setHoraInicial(Integer horaInicial){
        this.horaInicial = horaInicial;
    }

    public Integer getHoraFinal(){
        return horaFinal;
    }

    public void setHoraFinal(Integer horaFinal){
        this.horaFinal = horaFinal;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
}