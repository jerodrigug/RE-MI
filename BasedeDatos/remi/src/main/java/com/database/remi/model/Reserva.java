package com.database.remi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

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
  private Date fechaInicial;

  @NotNull
  private Date fechaFinal;

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

 public Date getCreatedAt(){
    return createdAt;
  }

  public Date getFechaInicial(){
    return fechaInicial;
  }

  public Date getFechaFinal(){
    return fechaFinal;
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

  public void setCreatedAt(Date createdAt){
    this.createdAt= createdAt;
  }

  public void setFechaInicial(Date fechaInicial){
    this.fechaInicial = fechaInicial;
  }

  public void setFechaFinal(Date fechaFinal){
    this.fechaFinal = fechaFinal;
  }

  

  public void setSalon(Salon salon){
    this.salon = salon;
  }

  public void setUsuario(Usuario usuario){
    this.usuario=usuario;
  }
}