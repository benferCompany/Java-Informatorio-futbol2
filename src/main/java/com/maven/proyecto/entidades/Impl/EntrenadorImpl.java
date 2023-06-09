package com.maven.proyecto.entidades.Impl;

import com.maven.proyecto.entidades.Entrenador;
import java.util.Scanner;

public class EntrenadorImpl extends Persona implements Entrenador {

    int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
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

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + super.getNombre() + ',' + "apellido=" + super.getApellido() + ',' + "edad=" + this.edad + '}';
    }

}
