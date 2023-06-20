package com.maven.proyecto.entidades;

import java.util.ArrayList;
import java.util.List;
public class Equipo {

    public int ID;
    protected static int idIncrement = 1;
    private String nombre;
    protected List<Jugador> jugadores = new ArrayList<Jugador>();
    private Entrenador entrenador;
    protected List<Equipo> equipo = new ArrayList<Equipo>();

  
    @Override
    public String toString() {
        return "Equipo{" + "ID=" + ID + ", nombre=" + nombre + ", jugadores=" + jugadores + ", entrenador=" + entrenador + '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugador) {
        this.jugadores.addAll(jugador);
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo.add(equipo);
    }

}

