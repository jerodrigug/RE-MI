package com.database.remi.model;

import javax.persistence.Entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RolName name;

    public Rol(){

    }

    public Rol(RolName name){
        this.name = name;
    }


    //Getters
    public Long getId(){
        return id;
    }

    public RolName getName(){
        return name;
    }

    //Setters
    public void setId(Long id){
        this.id=id;
    }

    public void setName(RolName name){
        this.name=name;
    }

}