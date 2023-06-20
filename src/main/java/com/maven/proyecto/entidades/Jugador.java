package com.maven.proyecto.entidades;


public class Jugador extends Persona{

    protected int idIncrement = 1;
    protected Double altura;
    protected Posiciones posicion;
    protected int cantidadDeGoles;
    protected int cantidadDePartidos;
    protected Boolean esCapitan;
    protected int numerosDeCamisetas;

        

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
    public void setIdIncrement(int i){
        this.idIncrement =i;
    }

}
