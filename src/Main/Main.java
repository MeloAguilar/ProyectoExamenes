package Main;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;
import Clases.Preguntas.PreguntaCorta;
import Clases.Preguntas.PreguntaTipoTest;
import Clases.Test.Test;
import Menu.Menu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println (Menu.MENSAJE_INICIAL);
        do {
            switch (sc.nextLine ( )) {
                case "1" -> {
                    System.out.println (Menu.MENSAJE_OPCION_UNO);
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
                case "2" -> {
                    double acierto = getPorcentajeAcierto ( );
                    System.out.println (acierto + "%" );
                }
                case "3" -> {
                    exit = true;
                }
                default -> {
                    System.out.println ("Escribe bien coño");
                }
            }
        } while (!exit);
    }



    //Case 1
    private static double getPorcentajeAcierto() {
        String nombreTest = Menu.pedirDato (sc, "El nombre del Test");
        double puntuacionDeLaSacada = Menu.RealizarTest (sc, nombreTest);
        List<Pregunta> preguntas = TestsDataAccess.reconstruirTest (nombreTest);
        double puntuacionReal = 0;
        for(Pregunta pregunta : preguntas){
            puntuacionReal += pregunta.getPuntuacion ();
        }
        return puntuacionDeLaSacada / puntuacionReal * 100 ;
    }


    //Case 2
    private static Test crearTestNuevo() {
        Test test = Menu.crearNuevoTest (sc);
        TestsDataAccess.introducirTestEnFichero (test);
//        System.out.println (test.getPreguntas ( ));
        return test;
    }


}
