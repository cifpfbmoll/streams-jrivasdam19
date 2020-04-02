package Ficheros;

import java.io.*;
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
                mensaje = "Error. El archivo de salida no se ha encontrado.\n";
                break;
            default:
                mensaje = "Error. Vuelva a intentarlo.\n";
        }
        return mensaje;
    }

    public void registrarError(String mensaje, Exception ex) {
        try {
            File ficheroErrores = new File("errores.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroErrores,true));
            escritor.write(mensaje, 0, mensaje.length());
            Date date = new Date();
            String strDateFormat = "hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
            String formattedDate = dateFormat.format(date);
            escritor.write(formattedDate, 0, formattedDate.length());
            PrintWriter imprimir = new PrintWriter(new File("errores.txt"));
            ex.printStackTrace(imprimir);
            imprimir.close();
            escritor.close();
        } catch (IOException excepcion) {
            System.out.println("Error al leer el archivo");
        }
    }

}
