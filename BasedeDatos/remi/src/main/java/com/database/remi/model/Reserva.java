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

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cod_salon", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Salon salon;

  @NotNull
  @Size(max = 100)
  private String estudiante;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @NotNull
  @Size(max = 10)
  private String horas;

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

  public String getCantHoras(){
    return horas;
  }

  public Salon getSalon(){
    return salon;
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

  public void setCantHoras(String horas){
    this.horas=horas;
  }

  public void setSalon(Salon salon){
    this.salon = salon;
  }

}