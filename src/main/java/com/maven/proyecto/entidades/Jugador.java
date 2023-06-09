package com.maven.proyecto.entidades;

import java.util.Scanner;

public interface Jugador {

    public Jugador crearJugador(Scanner scanner);
    public Jugador crearJugador(int ID, String nombre, String apellido, double altura, String posicion, int cantidadDeGoles, int cantidadDePartidos, boolean esCapitan, int numerosDeCamisetas);
    public int getID();
    public void setID(int ID);
    public String getNombre();
    public void setNombre(String nombre);
    public String getApellido();
    public void setApellido(String apellido);
    public Double getAltura();

    public void setAltura(Double altura);

    public Posiciones getPosicion();

    public void setPosicion(Posiciones posicion);

    public int getCantidadDeGoles();

    public void setCantidadDeGoles(int cantidadDeGoles);

    public int getCantidadDePartidos();

    public void setCantidadDePartidos(int cantidadDePartidos);

    public Boolean getEsCapitan();

    public void setEsCapitan(Boolean esCapitan);

    public int getNumerosDeCamisetas();

    public void setNumerosDeCamisetas(int numerosDeCamisetas);
}
