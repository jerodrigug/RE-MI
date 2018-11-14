package com.database.remi.payload;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class ReservaRequestMovil {

  @NotNull
  @Size(max = 8)
  private String tipo;

  @NotNull
  @Size(max = 30)
  private String instrumento;

  @NotNull
  @Size(max = 7)
  private String dia;

  @NotNull
  @Min(value = 8)
  @Max(value = 18)
  private Integer horaInicial;

  @NotNull
  @Min(value = 8)
  @Max(value = 18)
  private Integer horaFinal;


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
    this.instrumento = instrumento;
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
}