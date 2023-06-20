package com.maven.proyecto.entidades;


public class Entrenador extends Persona{

    protected int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + super.getNombre() + ',' + "apellido=" + super.getApellido() + ',' + "edad=" + this.edad + '}';
    }

}
