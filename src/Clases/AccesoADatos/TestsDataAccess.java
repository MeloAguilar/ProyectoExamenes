package Clases.AccesoADatos;

import Clases.Preguntas.Pregunta;
import Clases.Test.Test;
import Menu.Menu;

import java.io.*;
import java.util.TreeMap;

public class TestsDataAccess {

    public static final String EXTENSION = ".dat";
    public static final String PATH = ".\\src\\Ficheros\\";


    /**
     *Método que se encarga de cerrar el flujo de un Autocloseable
     * @param cl
     */
    private static void cerrarFlujo(AutoCloseable cl){
        try{
            cl.close ();
        }catch(Exception e){

        }
    }




    /**
     * <h2>introducirTestEnFichero(Test)</h2>
     *
     * Método que introduce las preguntas de un test en su fichero correspondiente.
     * Precondiciones: el Test introducido debe estar inicializado y debe contener preguntas en su Map de preguntas
     * Postcondiciones: El método devolverá un booleano que será true si se ha conseguido introducir el test en su
     * correspondiente fichero y false si no se consiguió realizar.
     * @param testAIntroducir
     * @return success
     */
    public static boolean introducirTestEnFichero(Test testAIntroducir){
        boolean success = false;
        ObjectOutputStream outputStream = null;
        MyobjectOutputStream miOutputStream = null;
        Pregunta pregunta;
        try {
            outputStream = new ObjectOutputStream (new FileOutputStream (testAIntroducir.getFicheroTest ()));
            miOutputStream = new MyobjectOutputStream (new FileOutputStream (testAIntroducir.getFicheroTest ()));
            for(int i = 0; i < testAIntroducir.getPreguntas ().size () ; i++) {
                pregunta = testAIntroducir.getPreguntas ( ).get (i+1);
                if (i < 1) {
                    outputStream.writeObject (pregunta);
                    success = true;
                } else {
                    miOutputStream.writeObject (pregunta);
                    success = true;
                }

            }
        }catch(IOException e){
            System.out.println (Menu.MENSAJEERROR);
        }finally{
            cerrarFlujo (outputStream);
            cerrarFlujo (miOutputStream);
        }
        return success;
    }


    /**
     * <h2>reconstruirTest()</h2>
     *
     * Método sencillo que reconstruye un Test a partir de su archivo.
     * Precondiciones: path debe ser una ruta válida en la que se encuentre archivado un test
     * Postcondiciones: Devolverá el test recogido de su ruta
     * @param path: Ruta de un archivo en el que se encuentran los datos de un test
     * @return test:
     */
    public static Test reconstruirTest(String path){
        ObjectInputStream inputStream = null;
        Test test = null;
        try{
            inputStream = new ObjectInputStream (new FileInputStream (path));
            test = (Test)inputStream.readObject ();
        }catch(IOException | ClassNotFoundException e){
            System.out.println (Menu.MENSAJEERROR );
        }finally {
            cerrarFlujo (inputStream);
        }
        return test;
    }



}
