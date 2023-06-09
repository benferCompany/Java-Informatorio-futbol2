package com.maven.proyecto.entidades;

import java.util.List;
import java.util.Scanner;

public interface Equipo {
    
    public Equipo crearEquipo(Scanner scanner);
    public Equipo buscarEquipo(Scanner scanner);
    public Jugador buscarJugador(Scanner scanner);
    public Jugador buscarCapitan(Scanner scanner);
    public void EliminarEquipo(Equipo equipo);
    public void importarJugadores(String url);
    public void exportarJugadores(String rutaArchivo);
    public int getID();

    public void setID(int ID);

    public String getNombre();

    public void setNombre(String nombre);

    public List<Jugador> getJugadores();

    public void setJugadores(List<Jugador> jugador);

    public Entrenador getEntrenador();

    public void setEntrenador(Entrenador entrenador);

    public List<Equipo> getEquipo();

    public void setEquipo(Equipo equipo);

}

