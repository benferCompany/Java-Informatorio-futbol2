package com.maven.proyecto.entidades.servicios;

import com.maven.proyecto.entidades.Jugador;
import com.maven.proyecto.services.entrada.file.impl.InputFileServiceImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class JugadorServicio extends Jugador {

    public Jugador crearJugador(Scanner scanner, int id) {
        this.setID(id);

        System.out.println("\n-----------------------------");
        System.out.println("\nJugador N°" + id);
        System.out.println("\n------------------------------");

        System.out.println("\nIngrese el nombre del jugador");
        this.setNombre(scanner.nextLine());
        System.out.println("\nAhora su apellido");
        this.setApellido(scanner.nextLine());
        System.out.println("\nLa altura");
        this.setAltura(Double.parseDouble(scanner.nextLine()));
        PosicionesServicio posicion = new PosicionesServicio();

        System.out.println("\nAhora debes escoger una posición para tu jugador");
        for (int i = 0; i < posicion.getPosiciones().size(); i++) {

            System.out.println(i + 1 + " " + posicion.getPosiciones().get(i));
        }

        posicion.crearPosiciones(posicion.getPosiciones().get(Integer.parseInt(scanner.nextLine()) - 1));

        this.setPosicion(posicion);
        System.out.println("\nLa cantidad de goles que tiene");
        this.setCantidadDeGoles(Integer.parseInt(scanner.nextLine()));
        System.out.println("\nCantidad de partidos jugados");
        this.setCantidadDePartidos(Integer.parseInt(scanner.nextLine()));
        System.out.println("\nAhora si es capitar o no");
        System.out.println("1- si es capitan");

        System.out.println("2- si no es capitan");
        int resultado = Integer.parseInt(scanner.nextLine());
        this.setEsCapitan(resultado == 1 ? true : false);

        System.out.println("\nEl numero de su camiseta");
        this.setNumerosDeCamisetas(Integer.parseInt(scanner.nextLine()));

        return this;
    }

    public Jugador crearJugador(int ID, String nombre, String apellido, double altura, String posicion, int cantidadDeGoles, int cantidadDePartidos, boolean esCapitan, int numerosDeCamisetas) {
        PosicionesServicio posicionx = new PosicionesServicio();
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

    public List<Jugador> crearListaJugador(List<String> contenido) {
        List<Jugador> listaDeJugadores = new ArrayList<Jugador>();
        for (int i = 0; i < contenido.size(); i++) {

            List<String> contenidoValor = new InputFileServiceImpl().inputFile(i, contenido, ",", "=");

            JugadorServicio jugador = new JugadorServicio();
            int ID = Integer.parseInt(contenidoValor.get(0));
            String nombre = contenidoValor.get(1);
            String apellido = contenidoValor.get(2);
            Double altura = Double.parseDouble(contenidoValor.get(3));
            String posicion = contenidoValor.get(4);
            int cantidadDeGoles = Integer.parseInt(contenidoValor.get(5));
            int cantidadDePartidos = Integer.parseInt(contenidoValor.get(6));
            boolean esCapitan = contenidoValor.get(7).equals("Es capitan");
            int numerosDeCamisetas = Integer.parseInt(contenidoValor.get(8));
            jugador.crearJugador(ID, nombre, apellido, altura, posicion, cantidadDeGoles, cantidadDePartidos, esCapitan, numerosDeCamisetas);
            listaDeJugadores.add(jugador);
        }
        return listaDeJugadores;
    }

    public List<Jugador> crearListaJugador(Scanner scanner) {
        int contador = 3;

        List<Jugador> jugadoresLista = new ArrayList<Jugador>();
        for (int i = 0; i < contador; i++) {
            JugadorServicio jugadorServicio = new JugadorServicio();
            jugadorServicio.crearJugador(scanner, i);
            jugadoresLista.add(jugadorServicio);

        }

        return jugadoresLista;
    }
}
