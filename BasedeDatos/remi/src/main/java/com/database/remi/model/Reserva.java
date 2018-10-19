package com.database.remi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createAt"}, allowGetters = true)
public class Reserva implements Serializable{
  

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 100)
  private String estudiante;

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

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cod_salon", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Salon salon;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cod_usuario", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Usuario usuario;

  

  
 
  //Getters
  public Long getId(){
    return id;
  }

  public String getEstudiante(){
    return estudiante;
  }

  public Date getCreatedAt(){
    return createdAt;
  }

  public Integer getHoraInicial(){
    return horaInicial;
  }

  public Integer getHoraFinal(){
    return horaFinal;
  }
  
  public String getDia(){
    return dia;
  }

  public Salon getSalon(){
    return salon;
  }

  public Usuario getUsuario(){
    return usuario;
  }

  //Setters
  public void setId(Long id){
    this.id = id;
  }

  public void setEstudiante(String estudiante){
    this.estudiante=estudiante;
  }

  public void setCreatedAt(Date createdAt){
    this.createdAt= createdAt;
  }

  public void setHoraInicial(Integer horaInicial){
    this.horaInicial = horaInicial;
  }

  public void setHoraFinal(Integer horaFinal){
    this.horaFinal = horaFinal;
  }

  public void setDia(String dia){
    this.dia = dia;
  }

  public void setSalon(Salon salon){
    this.salon = salon;
  }

  public void setUsuario(Usuario usuario){
    this.usuario=usuario;
  }
}