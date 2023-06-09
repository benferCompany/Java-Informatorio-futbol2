package com.maven.proyecto.entidades;

import java.util.Scanner;


public interface Entrenador {
    public Entrenador crearEntrenador(Scanner scanner);
    public String getNombre();
    public String getApellido();
}
