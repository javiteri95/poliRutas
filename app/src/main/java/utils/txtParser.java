package utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by joset on 21/11/2016.
 */

public class txtParser {

    public static Object getEdificioOrFacultad( String name, Context context) throws IOException{
        try {
            /**
            LinkedList<String> lista = new LinkedList<>();
            lista.add("FIEC");
            lista.add("FIMCP");
            lista.add("FIMCBOR");
            lista.add("FICT");
            lista.add("EDCOM");
            lista.add("FSCH");
             */

            // TODO code application logic here

            String[] lector;
            BufferedReader logFile = new BufferedReader(new InputStreamReader(context.getAssets().open("archivo.txt"), "UTF-8"));
            String linea = logFile.readLine();
            while (linea!= null){
                lector = linea.split(",");
                if (lector[0].equals(name) && (lector.length ==3) ){ //condicion sea facultad
                    String[] temporal1;
                    String coordenadaCentral = lector[1];

                    String[] temporal2;
                    String coordenadasP = lector[2];
                    temporal2 = coordenadasP.split(":");

                    temporal1 = coordenadaCentral.split(";");
                    Coordenada central = new Coordenada(Double.parseDouble(temporal1[0]), Double.parseDouble(temporal1[1]));
                    LinkedList<Coordenada> coordenadas = new LinkedList<>();

                    for ( int i = 0 ; i<temporal2.length ; i++){
                        String[] temporal3;
                        String coordenada = temporal2[i];
                        temporal3 = coordenada.split(";");

                        coordenadas.add(new Coordenada(Double.parseDouble(temporal3[0]), Double.parseDouble(temporal3[1])));
                    }
                    Facultad facultad = new Facultad(lector[0], central, coordenadas);
                    return facultad;


                }else if (lector.length > 4) {
                    String[] temporal4;
                    String seudonimos = lector[3];
                    temporal4 = seudonimos.split(":");
                    if (Arrays.asList(temporal4).contains(name) || lector[0].equals(name)){
                        String[] temporal5;
                        String[] temporal6;
                        temporal5 = lector[1].split(";");
                        temporal6 = lector[2].split(";");

                        Coordenada real = new Coordenada(Double.parseDouble(temporal5[0]), Double.parseDouble(temporal5[1]));
                        Coordenada fict =new Coordenada(Double.parseDouble(temporal6[0]), Double.parseDouble(temporal6[1]));
                        LinkedList<String> seudonimosL = new LinkedList<>();
                        for (int i = 0 ; i< temporal4.length; i++){
                            seudonimosL.add(temporal4[i]);
                        }

                        Edificio edificio = new Edificio(lector[0], real, fict,seudonimosL, lector[lector.length-1]);
                        return edificio;
                    }




                }
                linea = logFile.readLine();
            }

            //System.out.println(contador);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    return null;
    }

}
