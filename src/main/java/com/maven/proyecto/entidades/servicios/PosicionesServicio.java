package com.maven.proyecto.entidades.servicios;

import com.maven.proyecto.entidades.Posiciones;

public class PosicionesServicio extends Posiciones {
     
    public Posiciones crearPosiciones(String posicion) {
        this.ID=IDIncrement;
        this.posicion = posicion;
        IDIncrement++;
        return this;
        
    }
    
}
