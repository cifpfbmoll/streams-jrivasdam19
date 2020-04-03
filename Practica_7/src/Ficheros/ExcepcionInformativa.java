package Ficheros;

public class ExcepcionInformativa extends Exception{
    
    private String mensaje = "Error. No has introducido una ruta correcta, vuelve a intentarlo.\n";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ExcepcionInformativa() {
        super();
        this.setMensaje(mensaje);
    }
    
    
}
