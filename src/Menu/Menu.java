package Menu;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;
import Clases.Preguntas.PreguntaCorta;
import Clases.Preguntas.PreguntaTipoTest;
import Clases.Test.Test;

import java.util.*;

public class Menu {

    public static final String MENSAJEERROR = "Se rompió";
    public static final String MENSAJE_INICIAL = "1 --> Crear Test\n2 --> Realizar Test";
    public static final String MENSAJE_OPCION_UNO = "1 --> mostrar un Test\n2 --> Crear un Test";

    /**
     * <h2>pedirDato(Scanner, String)</h2>
     * <p>
     * Método que devuelve un String introducido por teclado
     * <p>
     * Precondiciones: ninguna
     * Postcondiciones: ninguna
     *
     * @param sc
     * @param datoAIntroducir
     * @return
     */
    public static String pedirDato(Scanner sc, String datoAIntroducir) {
        String mensaje = "introduzca aquí ";
        System.out.println (mensaje + datoAIntroducir);
        return sc.nextLine ( );
    }


    /**
     * <h2>crearPreguntasDeUntest(Scanner)</h2>
     *
     * Método que establece las preguntas de un test pidiendoselas al usuario por teclado
     * Precondiciones:
     * Postcondiciones:
     * @param sc
     * @return
     */
    public static List<Pregunta> crearPreguntasDeUnTest(Scanner sc){
        List<Pregunta> preguntas = new LinkedList<> (  );
        Pregunta p = null;
        boolean exit = false;
        do{
            String tipoPregunta = Menu.pedirDato (sc, "\n1 --> Pregunta corta\n2 --> Pregunta tipo test");
            String enunciado = Menu.pedirDato (sc, "el enunciado de la pregunta");
            switch(tipoPregunta){
                case "1" -> {
                    p = new PreguntaCorta (enunciado,1, Menu.pedirDato (sc, "La respuesta correcta de la pregunta"));
                    preguntas.add (p);

                }
                case "2" -> {
                    List<String> posiblesRespuestas =  establecerOpcionesPreguntaTest (sc);
                    System.out.println (posiblesRespuestas );
                    p = new PreguntaTipoTest (enunciado, 2,posiblesRespuestas,escogerRespuestaCorrectaParaTipoTest (sc));
                            preguntas.add ( p);

                }default -> {
                    System.out.println ( "Introduzca un dato válido" );
                }
            }
            if((pedirDato (sc,"no si quiere salir")).equals ("no")){
                exit = true;
            }
        }while(!exit);
        return preguntas;
    }


    /**
     * Método que sirve para establecer por teclado la respuesta correcta de una pregunta tipo test
     * @param sc
     * @return
     */
    private static char escogerRespuestaCorrectaParaTipoTest(Scanner sc){
        char opcionCorrecta = 'a';
        return pedirDato (sc, "el caracter de la respuesta correcta").toCharArray ()[0];
    }


    /**
     * Método que establece las opciones de una pregunta tipo test mediante datos pedidos al usuario por teclado
     * @param sc
     * @return
     */
    private static List<String> establecerOpcionesPreguntaTest(Scanner sc){
        List<String> posiblesRespuestas  = new LinkedList<> (  );
        boolean exit = false;
        do{
            String posibleRespuesta = pedirDato (sc, "una posible respuesta para la regunta");
            posiblesRespuestas.add ( posibleRespuesta);

            if(pedirDato (sc,"no si quiere salir").equals ("no")){
                exit = true;
            }
        }while(!exit);
    return posiblesRespuestas;
    }


    /**
     * Método que genera un test a partir de datos introducidos mediante scanner
     * @param sc
     * @return
     */
    public static Test crearNuevoTest(Scanner sc){
        String nombre = pedirDato (sc, "el nombre del test");
        List<Pregunta> preguntas = new LinkedList<> (  );
        boolean exit = false;
        do {
            switch (pedirDato (sc, "\n1 --> Crear preguntas \n2 --> Generar automaticamente preguntas")) {
                case "1" -> {
                    preguntas = crearPreguntasDeUnTest (sc);
                    exit = true;
                }
                case "2" -> {
                    List<String> respuestasTT = new LinkedList<> ( );
                    respuestasTT.add ( "r1");
                    respuestasTT.add ("r2");
                    respuestasTT.add ("r3");
                    respuestasTT.add ("r4");
                    Pregunta p1 = new PreguntaCorta ("Pregunta 1", 1, "respuesta1");
                    Pregunta p2 = new PreguntaTipoTest ("Pregunta 2", 2, respuestasTT, 'c');
                    Pregunta p3 = new PreguntaCorta ("Pregunta 3", 2, "respuesta3");
                    preguntas.add ( p1);
                    preguntas.add ( p2);
                    preguntas.add ( p3);
                    exit = true;
                }
            }
        }while(!exit);
        return new Test (nombre, preguntas);
    }


    /**
     *
     * @param sc
     * @param nombreTest
     * @return
     */
    public static double RealizarTest(Scanner sc, String nombreTest){
        double puntuacion = 0;
        LinkedList<Pregunta> preguntas = (LinkedList<Pregunta>) TestsDataAccess.reconstruirTest (nombreTest);
        System.out.println ("**********************************************************\n"+nombreTest+"\n**********************************************************\n" );
        for(Pregunta pregunta: preguntas){
            System.out.println (pregunta.getEnunciado () );
            if(pregunta instanceof PreguntaCorta){
                System.out.println ("Introduce la respuesta" );
                if(sc.nextLine ().equals (((PreguntaCorta) pregunta).getRespuestaCorrecta ())){
                    puntuacion += pregunta.getPuntuacion ();
                }
            } else {
                char letra = 'a';
                PreguntaTipoTest test = (PreguntaTipoTest) pregunta;
                for(String posibleR : ((PreguntaTipoTest) pregunta).getPosiblesRespuestas ()){
                    System.out.println (letra + " --> " +posibleR );
                    letra++;
                }
                System.out.println ("Introduce el caracter de la respuesta" );
                if(sc.nextLine ().equals (test.getRespuestaCorrecta ())){
                    puntuacion += pregunta.getPuntuacion ();
                }else{
                    if(puntuacion > pregunta.getPuntuacion ()){
                        puntuacion -= ((PreguntaTipoTest) pregunta).getPuntuacionReal ();
                    } else {
                        puntuacion = 0;
                    }
                }
            }
        }
        return puntuacion;
    }

}
