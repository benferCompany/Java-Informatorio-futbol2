package com.maven.proyecto.entidades.servicios;

import com.maven.proyecto.entidades.Entrenador;
import java.util.Scanner;

public class EntrenadorServicio extends Entrenador{

    public Entrenador crearEntrenador(Scanner scanner) {
        System.out.println("\n--------------------------------");
        System.out.println("\nIngrese el nombre del entrenador");
        System.out.println("\n---------------------------------");
        this.setNombre(scanner.nextLine());
        System.out.println("\nAhora el apellido");
        this.setApellido(scanner.nextLine());
        System.out.println("\nPor ultimo la edad");
        this.edad = Integer.parseInt(scanner.nextLine());
        return this;
    }
}
