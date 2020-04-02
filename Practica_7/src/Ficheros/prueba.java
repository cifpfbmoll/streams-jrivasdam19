package Ficheros;

import java.io.*;

public class prueba {

    public static void main(String[] args) {
        int i;
        int contador = 0;
        String cabecera = "--------------------------------------\n\n"
                + "Cartelera de CineFBMoll\n\n"
                + "--------------------------------------\n\n"
                + "----";
        String[] atributoPeli = {"------\n\nAño: ", "\n\nDirector: ", "\n\nDuración: ",
            "\n\nSinopsis: ", "\n\nReparto: ", "\n\nSesión: "};
        String tituloPeli = "\n\n------";
        String finalCartelera = "\n\n--------------------------";
//lectura con try with resources - autoclosable
        try (FileInputStream fin = new FileInputStream("cartelera.txt");
                FileOutputStream destino = new FileOutputStream("nuevo.txt");) {
//Leer bytes hasta que se encuentre el EOF (end of file)
//EOF es una marca para determinar el final de un archivo, es decir -1
            destino.write(cabecera.getBytes());
            do {
                i = fin.read();
                if (((char) i) == '#') {
                    if (contador < atributoPeli.length) {
                        destino.write(atributoPeli[contador].getBytes());
                        contador++;
                    } else {
                        contador = 0;
                    }
                } else if (((char) i) == '{') {
                    destino.write(tituloPeli.getBytes());
                } else {
                    destino.write(i);
                }

            } while (i != -1);
            destino.write(finalCartelera.getBytes());//Cuando i es igual a -1, se ha 
            //alcanzado el final del archivo EOF
        } catch (IOException exc) {
            System.out.println("Error al leer el archivo");
            System.out.println(exc.getMessage());
        }
    }
}
