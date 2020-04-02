package Ficheros;

import java.io.*;
import java.util.*;

public class GestionarFicheros {

    private static final String CABECERA = "--------------------------------------\n\n"
            + "Cartelera de CineFBMoll\n\n"
            + "--------------------------------------\n\n"
            + "----";
    private static final String[] ATRIBUTOPELI = {"------\n\nAño: ", "\n\nDirector: ", "\n\nDuración: ",
        "\n\nSinopsis: ", "\n\nReparto: ", "\n\nSesión: "};
    private static final String TITULOPELI = "\n\n------";
    private static final String PIE = "\n\n--------------------------";

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
                    try {
                        File ficheroEntrada = rutaEntrada();
                        File ficheroSalida = rutaSalida();
                        redactarFicheroByte(ficheroEntrada, ficheroSalida);
                    } catch (IOException excepcion) {
                        System.out.println("");
                        System.out.println("Error al leer el archivo");
                        System.out.println("");
                    } catch (ExcepcionPersonalizada ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        ex.registrarError(ex.getMessage(),ex);
                    }
                    break;
                case 2:
                    try {
                        File ficheroEntrada = rutaEntrada();
                        File ficheroSalida = rutaSalida();
                        redactarFicheroCaracter(ficheroEntrada, ficheroSalida);
                    } catch (IOException ex) {
                        System.out.println("Error al leer el archivo");
                    } catch (ExcepcionPersonalizada ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        ex.registrarError(ex.getMessage(),ex);
                    }
                    break;
                case 3:
                    try {
                        File ficheroEntrada = rutaEntrada();
                        File ficheroSalida = rutaSalida();
                        redactarFicheroLinea(ficheroEntrada, ficheroSalida);
                    } catch (IOException ex) {
                        System.out.println("Error al leer el archivo");
                    } catch (ExcepcionPersonalizada ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        ex.registrarError(ex.getMessage(),ex);
                    }
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

    public static File rutaEntrada() throws ExcepcionPersonalizada {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca el nombre del archivo de entrada.");
        String rutaEntrada = lector.nextLine() + ".txt";
        File ficheroEntrada = new File(rutaEntrada);
        boolean existe = ficheroEntrada.exists();
        if (!existe) {
            throw new ExcepcionPersonalizada(001);
        }
        return ficheroEntrada;
    }

    public static File rutaSalida() throws ExcepcionPersonalizada {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca el nombre del archivo de salida.");
        String rutaSalida = lector.nextLine() + ".txt";
        File ficheroSalida = new File(rutaSalida);
        boolean existe = ficheroSalida.exists();
        if (!existe) {
            throw new ExcepcionPersonalizada(002);
        }
        return ficheroSalida;
    }

    public static void redactarFicheroByte(File entrada, File salida) throws IOException {
        FileInputStream origen = new FileInputStream(entrada);
        FileOutputStream destino = new FileOutputStream(salida);
        int unByte;
        int contador = 0;
        destino.write(CABECERA.getBytes());
        do {
            unByte = origen.read();
            if (((char) unByte) == '#') {
                destino.write(ATRIBUTOPELI[contador].getBytes());
                contador++;
                if (contador >= ATRIBUTOPELI.length) {
                    contador = 0;
                }

            } else if (((char) unByte) == '{') {
                destino.write(TITULOPELI.getBytes());
            } else {
                destino.write(unByte);
            }

        } while (unByte != -1);
        destino.write(PIE.getBytes());
    }

    public static void redactarFicheroCaracter(File entrada, File salida) throws IOException {
        FileReader reader = new FileReader(entrada);
        FileWriter writer = new FileWriter(salida);
        int unCaracter;
        int contador = 0;
        for (int i = 0; i < CABECERA.length(); i++) {
            writer.write(CABECERA.charAt(i));
        }
        while ((unCaracter = reader.read()) != -1) {
            if (((char) unCaracter) == '#') {
                for (int i = 0; i < ATRIBUTOPELI[contador].length(); i++) {
                    writer.write(ATRIBUTOPELI[contador].charAt(i));
                }
                contador++;
                if (contador >= ATRIBUTOPELI.length) {
                    contador = 0;
                }
            } else if (((char) unCaracter) == '{') {
                for (int i = 0; i < TITULOPELI.length(); i++) {
                    writer.write(TITULOPELI.charAt(i));
                }
            } else {
                writer.write(unCaracter);
            }
        }
        for (int i = 0; i < PIE.length(); i++) {
            writer.write(PIE.charAt(i));
        }
        reader.close();
        writer.close();
    }

    public static void redactarFicheroLinea(File entrada, File salida) throws IOException {
        BufferedReader lectorMejorado = new BufferedReader(new FileReader(entrada));
        BufferedWriter escritorMejorado = new BufferedWriter(new FileWriter(salida));
        int contador = 0;
        boolean eof = false;
        String lineaLeida;
        escritorMejorado.write(CABECERA, 0, CABECERA.length());
        while (!eof) {
            lineaLeida = lectorMejorado.readLine();
            if (lineaLeida != null) {
                for (int i = 0; i < lineaLeida.length(); i++) {
                    if (lineaLeida.charAt(i) == '#') {
                        lineaLeida = lineaLeida.substring(0, i) + ATRIBUTOPELI[contador]
                                + lineaLeida.substring(i + 1);
                        contador++;
                        if (contador >= ATRIBUTOPELI.length) {
                            contador = 0;
                        }
                    } else if (lineaLeida.charAt(i) == '{') {
                        lineaLeida = lineaLeida.substring(0, i) + TITULOPELI
                                + lineaLeida.substring(i + 1);
                    }
                }
                escritorMejorado.write(lineaLeida, 0, lineaLeida.length());

            } else {
                eof = true;
            }

        }
        escritorMejorado.write(PIE, 0, PIE.length());
        lectorMejorado.close();
        escritorMejorado.close();
    }
}
