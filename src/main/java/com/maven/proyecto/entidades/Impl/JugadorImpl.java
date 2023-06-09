package com.maven.proyecto.entidades.Impl;

import com.maven.proyecto.entidades.Jugador;
import com.maven.proyecto.entidades.Posiciones;
import java.util.Scanner;

public class JugadorImpl extends Persona implements Jugador {

    private static int idIncrement = 1;
    Double altura;
    Posiciones posicion;
    int cantidadDeGoles;
    int cantidadDePartidos;
    Boolean esCapitan;
    int numerosDeCamisetas;

    @Override
    public Jugador crearJugador(Scanner scanner) {
        this.setID(idIncrement);

        System.out.println("\n-----------------------------");
        System.out.println("\nJugador N°" + this.getID());
        System.out.println("\n------------------------------");

        System.out.println("\nIngrese el nombre del jugador");
        this.setNombre(scanner.nextLine());
        System.out.println("\nAhora su apellido");
        this.setApellido(scanner.nextLine());
        System.out.println("\nLa altura");
        this.altura = Double.parseDouble(scanner.nextLine());
        Posiciones posicion = new PosicionesImpl();

        System.out.println("\nAhora debes escoger una posición para tu jugador");
        for (int i = 0; i < posicion.getPosiciones().size(); i++) {

            System.out.println(i + 1 + " " + posicion.getPosiciones().get(i));
        }

        posicion.crearPosiciones(posicion.getPosiciones().get(Integer.parseInt(scanner.nextLine()) - 1));

        this.posicion = posicion;
        System.out.println("\nLa cantidad de goles que tiene");
        this.cantidadDeGoles = Integer.parseInt(scanner.nextLine());
        System.out.println("\nCantidad de partidos jugados");
        this.cantidadDePartidos = Integer.parseInt(scanner.nextLine());
        System.out.println("\nAhora si es capitar o no");
        System.out.println("1- si es capitan");

        System.out.println("2- si no es capitan");
        int resultado = Integer.parseInt(scanner.nextLine());
        this.esCapitan = resultado == 1 ? true : false;

        System.out.println("\nEl numero de su camiseta");
        this.numerosDeCamisetas = Integer.parseInt(scanner.nextLine());
        this.idIncrement++;
        
        return this;
    }

    public Jugador crearJugador(int ID, String nombre, String apellido, double altura, String posicion, int cantidadDeGoles, int cantidadDePartidos, boolean esCapitan, int numerosDeCamisetas) {
        Posiciones posicionx = new PosicionesImpl();
        posicionx.crearPosiciones(posicion);
        this.setID(ID);

        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setAltura(altura);
        this.setPosicion(posicionx);
        this.setCantidadDeGoles(cantidadDeGoles);
        this.setCantidadDePartidos(cantidadDePartidos);
        this.setEsCapitan(esCapitan);
        this.setNumerosDeCamisetas(numerosDeCamisetas);
        return this;
    }

    @Override
    public String toString() {
        return "Jugador{" + "ID=" + this.getID() + ", Nombre=" + this.getNombre() + ", Nombre=" + this.getApellido() + ", Altura=" + altura + ", posicion=" + posicion + ", cantidadDeGoles=" + cantidadDeGoles + ", cantidadDePartidos=" + cantidadDePartidos + ", esCapitan=" + esCapitan + ", numerosDeCamisetas=" + numerosDeCamisetas + '}';
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Posiciones getPosicion() {
        return posicion;
    }

    public void setPosicion(Posiciones posicion) {
        this.posicion = posicion;
    }

    public int getCantidadDeGoles() {
        return cantidadDeGoles;
    }

    public void setCantidadDeGoles(int cantidadDeGoles) {
        this.cantidadDeGoles = cantidadDeGoles;
    }

    public int getCantidadDePartidos() {
        return cantidadDePartidos;
    }

    public void setCantidadDePartidos(int cantidadDePartidos) {
        this.cantidadDePartidos = cantidadDePartidos;
    }

    public Boolean getEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(Boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNumerosDeCamisetas() {
        return numerosDeCamisetas;
    }

    public void setNumerosDeCamisetas(int numerosDeCamisetas) {
        this.numerosDeCamisetas = numerosDeCamisetas;
    }

}
