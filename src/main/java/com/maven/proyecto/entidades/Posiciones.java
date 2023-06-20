package com.maven.proyecto.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Posiciones {
    protected static int IDIncrement =1;
    protected int ID;
    protected String posicion;
    private final List<String> posiciones = new ArrayList<String>(Arrays.asList("Arquero","Defensor","Mediocampista","Delantero","Suplente"));

   

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
