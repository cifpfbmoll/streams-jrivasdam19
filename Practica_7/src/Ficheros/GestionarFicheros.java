package Ficheros;

import java.io.File;
import java.util.*;

public class GestionarFicheros {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println("---- MENU PRINCIPAL ----");
            System.out.println("1.- Leer y escribir byte a byte.");
            System.out.println("2.- Leer y escribir carácter a carácter.");
            System.out.println("3.- Leer y escribir con buffers.");
            System.out.println("4.- Salir.");
            int opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                    //byte a byte
                    break;
                case 2:
                    //caracter
                    break;
                case 3:
                    // buffers
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Error. Opcion incorrecta.");
                    break;
            }
        }
    }

    public static File rutaEntrada() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca la ruta de entrada del texto.");
        String rutaEntrada = lector.nextLine();
        File ficheroEntrada = new File(rutaEntrada);
        return ficheroEntrada;

    }

    public static File rutaSalida() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca la ruta de salida del texto.");
        String rutaSalida = lector.nextLine();
        File ficheroSalida = new File(rutaSalida);
        return ficheroSalida;
    }
}
