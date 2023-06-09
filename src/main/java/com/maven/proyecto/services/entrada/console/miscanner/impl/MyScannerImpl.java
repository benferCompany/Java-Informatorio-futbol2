package com.maven.proyecto.services.entrada.console.miscanner.impl;

import java.util.Scanner;

import com.maven.proyecto.services.entrada.console.miscanner.MyScanner;

public class MyScannerImpl implements MyScanner{
    private static MyScannerImpl myScanner;
    private static Scanner scanner;
    
    private MyScannerImpl(){
        scanner = new Scanner(System.in);
    }
   
    public static MyScannerImpl getInstance(){
        if(myScanner==null){
            myScanner= new MyScannerImpl();
        }
        return myScanner;
    }
    
    @Override
    public Scanner getScan(){
        return scanner;
    }

}
