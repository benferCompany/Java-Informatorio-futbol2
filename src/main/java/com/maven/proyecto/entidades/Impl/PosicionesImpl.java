package com.maven.proyecto.entidades.Impl;

import com.maven.proyecto.entidades.Posiciones;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosicionesImpl implements Posiciones {
    private static int IDIncrement =1;
    private int ID;
    private String posicion;
    private final List<String> posiciones = new ArrayList<String>(Arrays.asList("Arquero","Defensor","Mediocampista","Delantero","Suplente"));

    public Posiciones crearPosiciones(String posicion) {
        this.ID=IDIncrement;
        this.posicion = posicion;
        IDIncrement++;
        return this;
        
    }

    @Override
    public String toString() {
        return "Posiciones{" + "ID=" + ID + ", posicion=" + posicion + '}';
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public List<String> getPosiciones() {
        return posiciones;
    }

    
}
