package Main;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;
import Clases.Test.Test;
import Menu.Menu;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    private static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        System.out.println ("1 --> mostrar\n2 --> Crear test");
        switch (sc.nextLine ( )) {
            case "1" -> {

                LinkedList<Pregunta> test = (LinkedList<Pregunta>) TestsDataAccess.reconstruirTest (Menu.pedirDato (sc, "la ruta del archivo"));
                for (Pregunta pregunta : test) {
                    System.out.println (pregunta);
                }
            }
            case "2" -> {
                Test test = crearTestNuevo ( );
            }
        }
    }
    /*

     */

    private static Test crearTestNuevo() {
        Test test = Menu.crearNuevoTest (sc);
        TestsDataAccess.introducirTestEnFichero (test);
//        System.out.println (test.getPreguntas ( ));
        return test;
    }


}
