package utils;

import java.util.LinkedList;

/**
 * Created by joset on 26/11/2016.
 */

public class Edificio {

    private String name;
    private Coordenada realLocation;
    private Coordenada fictRutas;
    private LinkedList<String> seudon;
    private String image;


    public Edificio(String name, Coordenada realLocation) {
        this.name = name;
        this.realLocation = realLocation;
    }

    public Edificio(String name, Coordenada realLocation, Coordenada fictRutas, LinkedList<String> seudon, String image) {
        this.name = name;
        this.realLocation = realLocation;
        this.fictRutas = fictRutas;
        this.seudon = seudon;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordenada getRealLocation() {
        return realLocation;
    }

    public void setRealLocation(Coordenada realLocation) {
        this.realLocation = realLocation;
    }

    public Coordenada getFictRutas() {
        return fictRutas;
    }

    public void setFictRutas(Coordenada fictRutas) {
        this.fictRutas = fictRutas;
    }

    public LinkedList<String> getSeudon() {
        return seudon;
    }

    public void setSeudon(LinkedList<String> seudon) {
        this.seudon = seudon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
