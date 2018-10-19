package com.database.remi.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Horas implements Serializable {

    private static final long serialVersionUID = 1L;

    public Map<Integer,  Boolean> horarios = new HashMap<Integer, Boolean>();

    public Map<Integer,  Boolean> getHorario(){
        return horarios;
    }
   
    public void setHorario(Map<Integer,  Boolean> horarios){
      this.horarios = horarios;
    }

    public Map<Integer,  Boolean> createHorario(){
        for (int variable = 8; variable < 19; variable++){
            horarios.put(variable, false);
          }
     return horarios;
    }
}