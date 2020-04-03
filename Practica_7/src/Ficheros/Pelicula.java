package Ficheros;

import java.io.*;
import java.util.*;

public class Pelicula implements Serializable {

    private String titulo;
    private String anyo;
    private String director;
    private String duracion;
    private String sinopsis;
    private String reparto;
    private String sesion;

    public Pelicula() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public Pelicula(String titulo, String anyo, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.setTitulo(titulo);
        this.setAnyo(anyo);
        this.setDirector(director);
        this.setDuracion(duracion);
        this.setSinopsis(sinopsis);
        this.setReparto(reparto);
        this.setSesion(sesion);
    }
    
    public String atributosPelicula(){
        String atributos="";
        atributos+="-----"+this.getTitulo()+"-----\n";
        atributos+="Año: "+this.getAnyo()+"\n";
        atributos+="Director: "+this.getDirector()+"\n";
        atributos+="Duración: "+this.getDuracion()+"\n";
        atributos+="Sinopsis: "+this.getSinopsis()+"\n";
        atributos+="Reparto: "+this.getReparto()+"\n";
        atributos+="Sesión: "+this.getSesion()+"\n";
        return atributos;                
    }

   


}