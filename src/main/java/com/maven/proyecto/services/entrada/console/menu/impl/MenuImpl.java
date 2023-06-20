package com.maven.proyecto.services.entrada.console.menu.impl;

import com.maven.proyecto.entidades.servicios.EquipoServicio;
import com.maven.proyecto.entidades.Jugador;
import java.util.Scanner;
import com.maven.proyecto.services.entrada.console.menu.Menu;
import com.maven.proyecto.services.entrada.console.miscanner.MyScanner;
import com.maven.proyecto.services.entrada.console.miscanner.impl.MyScannerImpl;

public class MenuImpl implements Menu {

    MyScanner myScanner = MyScannerImpl.getInstance();
    Scanner scanner = myScanner.getScan();
    EquipoServicio equipo = new EquipoServicio();

    public Scanner menuCrearEquipo() {
        try {
            System.out.println("\n-----------Equipos Cargados-------------");
            for (int i = 0; i < equipo.getEquipo().size(); i++) {
                System.out.println(i + 1 + "- " + equipo.getEquipo().get(i).getNombre());
            }
            System.out.println("\n-----------------------------------------");

            System.out.println("1- ¿Crear un equipo?");
            System.out.println("2- ¿Desea buscar y ver detalles de algún jugador por su nombre?");
            System.out.println("3- ¿Ver detales del equipo Ingresando nombre del entrenador y del capitan?");
            System.out.println("4- ¿Buscar equipo un equipo por su nombre y mostrar detalles?");
            System.out.println("5- ¿Quieres eliminar un equipo?");
            System.out.println("6- ¿Quieres exportar la lista de los jugadores?");
            System.out.println("7- ¿Quieres importar la lista de los jugadoes?");

            int respuesta = 0;
            respuesta = Integer.parseInt(scanner.nextLine());
            if (respuesta == 1) {
                equipo.crearEquipo(scanner);
                return this.menuCrearEquipo();

            }

            EquipoServicio buscarEquipo = equipo.buscarEquipo(scanner);

            if (buscarEquipo != null) {
                System.out.println("\nEl equipo si esta en la lista");

                switch (respuesta) {
                    case 2:

                        Jugador jugadorRespuesta = buscarEquipo.buscarJugador(scanner);
                        if (jugadorRespuesta != null) {
                            System.out.println("\n---------Datos del jugador-----------------\n");
                            
                            System.out.println("Nombre: " + jugadorRespuesta.getNombre());
                            System.out.println("Apellido: " + jugadorRespuesta.getApellido());
                            System.out.println("Posicion: " + jugadorRespuesta.getPosicion().getPosicion());
                            String esCapitan = (jugadorRespuesta.getEsCapitan()) ? "Es capitan" : "No es capitan";
                            System.out.println("Es capitan: " + esCapitan);
                            System.out.println("Nombre del equipo: " + buscarEquipo.getNombre());

                        }else{
                            System.out.println("\nNo se encontro ningún jugador con ese nombre");
                        }
                        System.out.println("\n------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("\nAhora el nombre del entrenador");
                        if (buscarEquipo.getEntrenador().getNombre().equals(scanner.nextLine())) {
                            System.out.println("\nCorrecto. Ahora el nombre del capitan");

                            Jugador buscarCapitan = buscarEquipo.buscarCapitan(scanner);
                            if (buscarCapitan != null) {
                                System.out.println("\n---------------Datos equipo-----------------");
                                System.out.println("Nombre del equipo: " + buscarEquipo.getNombre());
                                System.out.println("Nombre del entrenador: " + buscarEquipo.getEntrenador().getNombre());
                                System.out.println("Nombre del capitan: " + buscarCapitan.getNombre());
                            } else {
                                System.out.println("\nNo se econtro ese nombre o no es capoitan");

                            }

                        } else {
                            System.out.println("\n No coinciden con el nombre del entrenador");
                        }
                        break;
                    case 4:
                        String nombreEntrenador = buscarEquipo.getEntrenador().getNombre();
                        String apellidoEntrenador = buscarEquipo.getEntrenador().getApellido();
                        System.out.println("\n-------Detalles de Equipo------------");
                        System.out.println("Nombre: " + buscarEquipo.getNombre());
                        System.out.println("Nombre Entrenador: " + nombreEntrenador + " " + apellidoEntrenador);
                        for (int i = 0; i < buscarEquipo.getJugadores().size(); i++) {
                            String nombre = buscarEquipo.getJugadores().get(i).getNombre();
                            String apellido = buscarEquipo.getJugadores().get(i).getApellido();
                            String posicion = buscarEquipo.getJugadores().get(i).getPosicion().getPosicion();
                            System.out.println(i + 1 + "- " + nombre + " " + apellido + "| Posicion: " + posicion);
                        }
                        break;
                    case 5:
                        equipo.EliminarEquipo(buscarEquipo);
                        break;
                    case 6:
                        String rutaArchivoExportar = "src\\main\\java\\com\\maven\\proyecto\\resources\\salida.txt";
                        buscarEquipo.exportarJugadores(rutaArchivoExportar);
                        break;
                    case 7:
                        String rutaArchivoImportar = "src\\main\\java\\com\\maven\\proyecto\\resources\\entrada.txt";
                        buscarEquipo.importarJugadores(rutaArchivoImportar);
                        break;
                    default:
                        System.out.println("\nNo se encuenrta el equipo");
                        break;
                }

            } else {
                System.out.println("Al paracer no tenes cargado ningún equipo o ingresaste mal su nombre. Por favor pruebe creando uno");
            }
        } catch (Exception e) {

            if (e.getMessage().equals("Index 0 out of bounds for length 0")) {
                System.out.println("\n--------------------------------------------");
                System.out.println("\nNo tienen ningún equipo creado. Por favor cree uno");
                System.out.println("\n--------------------------------------------");
            } else if (e.getMessage().substring(0, 17).equals("For input string:")) {
                System.out.println("\n--------------------------------------------");
                System.out.println("\nIngresaste un dato invalido. Por favor vuelva a comenza");
                System.out.println("\n--------------------------------------------");
            } else {
                System.out.println(e.getMessage());
            }
        }

        return this.menuCrearEquipo();
    }

}
