package utils;

import java.util.LinkedList;

/**
 * Created by joset on 26/11/2016.
 */

public class Facultad {

    public String nombre;
    public Coordenada central;
    public LinkedList<Coordenada> coordenadas;

    public Facultad(String nombre, Coordenada central, LinkedList<Coordenada> coordenadas) {
        this.nombre = nombre;
        this.central = central;
        this.coordenadas = coordenadas;
    }

    public Facultad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(LinkedList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Coordenada getCentral() {
        return central;
    }

    public void setCentral(Coordenada central) {
        this.central = central;
    }
}
