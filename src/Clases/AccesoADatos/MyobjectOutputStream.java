package Clases.AccesoADatos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Clase ObjectOutputStream modificada para que no escriba cabeceras.
 */
public class MyobjectOutputStream extends ObjectOutputStream {

    @Override
    protected void writeStreamHeader() throws IOException {
        //No hacer nada
    }

    public MyobjectOutputStream() throws IOException{
        super();
    }

    public MyobjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }

}
