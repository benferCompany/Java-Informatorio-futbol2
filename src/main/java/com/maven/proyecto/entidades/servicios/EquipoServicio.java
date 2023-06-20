
package com.maven.proyecto.entidades.servicios;

import com.maven.proyecto.entidades.Equipo;
import com.maven.proyecto.entidades.Jugador;
import com.maven.proyecto.services.salida.file.impl.OutputFileServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Benjamin
 */
public class EquipoServicio extends Equipo {

    public EquipoServicio crearEquipo(Scanner scanner) {

        Equipo equipoNew = new EquipoServicio();
        this.ID = idIncrement;

        System.out.println("\nPara crea un equipo necesitamos crear primeros los jugadores");
        System.out.println("1- ¿Quieres crear los jugadores ahora mismo?");
        System.out.println("2- ¿Quieres crear los jugadores mas adelante importando desde un archivo?");
        int respuesta = Integer.parseInt(scanner.nextLine());
        if (respuesta == 1) {
            
            JugadorServicio jugadoresLista = new JugadorServicio();
            equipoNew.setJugadores (jugadoresLista.crearListaJugador(scanner));
            

        }
        equipoNew.setEntrenador(new EntrenadorServicio().crearEntrenador(scanner));

        System.out.println("\nAhora nos falta el nombre del equipo");
        equipoNew.setNombre(scanner.nextLine());
        this.setEquipo(equipoNew);
        this.idIncrement++;
        return this;
    }

    public EquipoServicio buscarEquipo(Scanner scanner) {
        if (this.getEquipo().get(0) != null) {
            System.out.println("\n--------Buscar Equipo---------------");
            System.out.println("\nIngrese el nombre del equipo");
            for (Equipo eq : this.getEquipo()) {
                if (scanner.nextLine().equals(eq.getNombre())) {
                    return (EquipoServicio) eq;
                }
            }
        }

        return null;
    }

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

    public Jugador buscarCapitan(Scanner scanner) {
        System.out.println("\nBuscar capitan");
        Jugador capitan = this.buscarJugador(scanner);

        if (capitan.getEsCapitan()) {
            return capitan;
        }
        return null;
    }


    public void exportarJugadores(String rutaArchivo) {
        List<String> listaJugadores = new ArrayList<String>();
        for (Jugador jgr : this.jugadores) {
            String esCapitan = jgr.getEsCapitan() ? "Es capitan" : "No es capitan";
            listaJugadores.add("ID=" + jgr.getID() + ", Nombre=" + jgr.getNombre() + ", Apellido=" + jgr.getApellido() + ", Altura=" + jgr.getAltura() + ", posicion=" + jgr.getPosicion().getPosicion() + ", cantidadDeGoles=" + jgr.getCantidadDeGoles() + ", cantidadDePartidos=" + jgr.getCantidadDePartidos() + ", esCapitan=" + esCapitan + ", numerosDeCamisetas=" + jgr.getNumerosDeCamisetas());
        }
        System.out.println(new OutputFileServiceImpl().outputFile(listaJugadores, rutaArchivo));
    }

    
    public void importarJugadores(String rutaArchivo) {

        

        try {
            List<String> contenido = FileUtils.readLines(new File(rutaArchivo), "UTF-8");

            JugadorServicio jugadorServicio = new JugadorServicio();
            
            this.jugadores = jugadorServicio.crearListaJugador(contenido);
            System.out.println("\n--------------------------------------------");
            System.out.println("\nLos datos fueron ingresados satisfactoriamente");
            System.out.println("\n---------------------------------------------");
        } catch (IOException e) {
            System.out.println("\n--------------------------------------------");
            System.out.println("\nno se pude importar datos");
            System.out.println("\n--------------------------------------------");
        }

    }

    
    public void EliminarEquipo(Equipo equipo) {
        System.out.println("\n---------------------------");
        if (this.equipo.remove(equipo)) {

            System.out.println("\nSe elimino correctamente");
        } else {
            System.out.println("No se pudo eliminar");
        }
        System.out.println("\n---------------------------");
    }
}
