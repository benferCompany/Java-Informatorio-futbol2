package com.maven.proyecto.entidades;

import java.util.List;

public interface Posiciones {

    public Posiciones crearPosiciones(String posicion);

    public int getID();

    public void setID(int ID);

    public String getPosicion();

    public void setPosicion(String posicion);

    public List<String> getPosiciones();
}
