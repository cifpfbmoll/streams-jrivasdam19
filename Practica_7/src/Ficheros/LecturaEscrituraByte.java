package Ficheros;

import java.util.*;
import java.io.*;

public class LecturaEscrituraByte {

    public LecturaEscrituraByte() {
    }

    public static String leerFichero(File ficheroEntrada, File ficheroSalida) throws IOException {
        FileInputStream fileIn = new FileInputStream(ficheroEntrada);
        int unCaracter;
        String lineasTexto="";
        boolean eof = false;
        while (!eof) {
            if ((unCaracter = fileIn.read()) != -1) {
                if (unCaracter == 35) {
                    
                }
                lineasTexto+=((char)unCaracter);
            }else{
                eof=true;
            }
            
        }fileIn.close();
    }

    public static void escribirFichero(File ficheroSalida, int opcion) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(ficheroSalida);
        String cabecera = "--------------------------------------\n"
                + "Cartelera de CineFBMoll\n"
                + "--------------------------------------\n"
                + "----";
        String[] atributoPeli = {"------\nAño: ", "\nDirector: ", "\nDuración: ",
            "\nSinopsis: ", "\nReparto: ", "\nSesión: "};
        String tituloPeli = "------";
        String finalCartelera = "--------------------------";
        fileOut.write(cabecera.getBytes());

    }
}
