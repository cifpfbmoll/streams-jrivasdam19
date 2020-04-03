package Ficheros;

import java.io.*;


public class prueba {

    public static void main(String[] args) {

        try{File archivo = new File ("cartelera.txt");
        BufferedReader lectorMejorado = new BufferedReader(new FileReader(archivo));
        boolean eof = false;
        String textoLeido = "";
        String[]TheOldMan=new String [6];
        String[]CapitanaMarvel=new String [6];
        String peli1="";
        String peli2="";
        String lineaLeida;
        while (!eof) {
            lineaLeida = lectorMejorado.readLine();
            if (lineaLeida != null) {
                textoLeido += lineaLeida;
            } else {
                eof = true;
            }
        }
        lectorMejorado.close();
        for(int i=0;i<textoLeido.length();i++){
            if(textoLeido.charAt(i)=='{'){
                peli1 = textoLeido.substring(0, i);
                peli2 = textoLeido.substring(i+1);
            }
        }
        TheOldMan=peli1.split("#");
        CapitanaMarvel=peli2.split("#");
        imprimir(TheOldMan);
        imprimir(CapitanaMarvel);
        
        
        } catch (Exception ex){
            System.out.println("");
        }
    }
    
    public static void imprimir(String[]peli){
        for(String p: peli){
            System.out.println(p);
        }
    }
}
