package com.maven.proyecto.entidades.Impl;

import com.maven.proyecto.entidades.Entrenador;
import com.maven.proyecto.entidades.Equipo;
import com.maven.proyecto.entidades.Jugador;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class EquipoImpl implements Equipo {

    private int ID;
    private static int idIncrement = 1;
    private String nombre;
    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private Entrenador entrenador;
    private List<Equipo> equipo = new ArrayList<Equipo>();

    @Override
    public Equipo crearEquipo(Scanner scanner) {

        Equipo equipoNew = new EquipoImpl();
        this.ID = idIncrement;

        System.out.println("\nPara crea un equipo necesitamos crear primeros los jugadores");
        System.out.println("1- ¿Quieres crear los jugadores ahora mismo?");
        System.out.println("2- ¿Quieres crear los jugadores mas adelante importando desde un archivo?");
        int respuesta = Integer.parseInt(scanner.nextLine());
        if (respuesta == 1) {
            int contador = 3;

            List<Jugador> jugadores = new ArrayList<Jugador>();
            for (int i = 0; i < contador; i++) {
                Jugador jugador = new JugadorImpl();
                jugador.crearJugador(scanner);
                jugadores.add(jugador);
            }
            equipoNew.setJugadores(null);

        }
        equipoNew.setEntrenador(new EntrenadorImpl().crearEntrenador(scanner));

        System.out.println("\nAhora nos falta el nombre del equipo");
        equipoNew.setNombre(scanner.nextLine());
        this.setEquipo(equipoNew);
        this.idIncrement++;
        return this;
    }

    @Override
    public Equipo buscarEquipo(Scanner scanner) {
        if (this.getEquipo().get(0) != null) {
            System.out.println("\n--------Buscar Equipo---------------");
            System.out.println("\nIngrese el nombre del equipo");
            for (Equipo eq : this.getEquipo()) {
                if (scanner.nextLine().equals(eq.getNombre())) {
                    return eq;
                }
            }
        }

        return null;
    }

    @Override
    public Jugador buscarJugador(Scanner scanner) {

        System.out.println("\n------Buscar Jugador-------------");
        System.out.println("\nIngrese el nombre del jugador");

        String nombreJugador = scanner.nextLine();
        for (Jugador jgorEncontrado : this.getJugadores()) {
            if (nombreJugador.equals(jgorEncontrado.getNombre())) {

                return jgorEncontrado;
            }
        }

        return null;
    }

    @Override
    public Jugador buscarCapitan(Scanner scanner) {
        System.out.println("\nBuscar capitan");
        Jugador capitan = this.buscarJugador(scanner);

        if (capitan.getEsCapitan()) {
            return capitan;
        }
        return null;
    }

    @Override
    public void exportarJugadores(String rutaArchivo) {
        List<String> listaJugadores = new ArrayList<String>();
        for (Jugador jgr : this.jugadores) {
            String esCapitan = jgr.getEsCapitan() ? "Es capitan" : "No es capitan";
            listaJugadores.add("ID=" + jgr.getID() + ", Nombre=" + jgr.getNombre() + ", Apellido=" + jgr.getApellido() + ", Altura=" + jgr.getAltura() + ", posicion=" + jgr.getPosicion().getPosicion() + ", cantidadDeGoles=" + jgr.getCantidadDeGoles() + ", cantidadDePartidos=" + jgr.getCantidadDePartidos() + ", esCapitan=" + esCapitan + ", numerosDeCamisetas=" + jgr.getNumerosDeCamisetas());
        }
        File archivo = new File("src\\main\\java\\com\\maven\\proyecto\\resources\\salida.txt");
        try {

            FileUtils.writeLines(archivo, "UTF-8", listaJugadores);

            System.out.println("\n-------Datos exportados correctamente.--------");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void importarJugadores(String rutaArchivo) {

        List<Jugador> listaDeJugadores = new ArrayList<Jugador>();

        try {
            List<String> contenido = FileUtils.readLines(new File(rutaArchivo), "UTF-8");

            for (int i = 0; i < contenido.size(); i++) {
                List<String> contenidoValor = new ArrayList<String>();
                String[] valoresComa = contenido.get(i).split(",");
                for (String valor : valoresComa) {

                    String[] partes = valor.split("=");

                    if (partes.length == 2) {
                        //String clave = partes[0];
                        String valorString = partes[1];

                        contenidoValor.add(valorString);

                    }
                }
                Jugador jugador = new JugadorImpl();
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
            this.jugadores = listaDeJugadores;
            System.out.println("\n--------------------------------------------");
            System.out.println("\nLos datos fueron ingresados satisfactoriamente");
            System.out.println("\n---------------------------------------------");
        } catch (IOException e) {
            System.out.println("\n--------------------------------------------");
            System.out.println("\nno se pude importar datos");
            System.out.println("\n--------------------------------------------");
        }

    }

    @Override
    public void EliminarEquipo(Equipo equipo) {
        System.out.println("\n---------------------------");
        if(this.equipo.remove(equipo)){
            
            System.out.println("\nSe elimino correctamente");
        }else{
            System.out.println("No se pudo eliminar");
        }
        System.out.println("\n---------------------------");
    }

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
