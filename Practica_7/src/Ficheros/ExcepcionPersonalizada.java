package Ficheros;

import java.io.*;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;

public class ExcepcionPersonalizada extends Exception {

    private int codigoError;

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public ExcepcionPersonalizada() {
    }

    public ExcepcionPersonalizada(int codigoError) {
        super();
        this.setCodigoError(codigoError);
    }

    @Override
    public String getMessage() {
        String mensaje;
        switch (this.getCodigoError()) {
            case 001:
                mensaje = "Error. El archivo de entrada no se ha encontrado.\n";
                break;
            case 002:
                mensaje = "Error. No has introducido una ruta correcta, vuelve a intentarlo.\n";
                break;
            default:
                mensaje = "Error. Vuelva a intentarlo.\n";
        }
        return mensaje;
    }

    public void registrarError(String mensaje, Exception ex) {
        try {
            File ficheroErrores = new File("errores.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroErrores, true));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            escritor.write(timestamp.toString() + "\n");
            escritor.write(mensaje + "\n", 0, mensaje.length());
            escritor.write(Arrays.toString(this.getStackTrace()) + "\n\n");
            escritor.close();
        } catch (IOException excepcion) {
            System.out.println("Error al leer el archivo");
        }
    }

}
