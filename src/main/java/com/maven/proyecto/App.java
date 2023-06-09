package com.maven.proyecto;

import com.maven.proyecto.services.entrada.console.menu.impl.MenuImpl;

public class App {

    public static void main(String[] args) {
     
        MenuImpl menu = new MenuImpl();
        System.out.println(menu.menuCrearEquipo());
    }
}
