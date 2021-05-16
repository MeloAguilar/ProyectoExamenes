package Menu;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;
import Clases.Preguntas.PreguntaCorta;
import Clases.Preguntas.PreguntaTipoTest;
import Clases.Test.Test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    public static final String MENSAJEERROR = "Se rompió";


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
    public static Map<Integer, Pregunta> crearPreguntasDeUnTest(Scanner sc){
        TreeMap<Integer, Pregunta> preguntas = new TreeMap<> (  );
        Pregunta p = null;
        boolean exit = false;
        int cointador = 1;
        do{
            String tipoPregunta = Menu.pedirDato (sc, "\n1 --> Pregunta corta\n2 --> Pregunta tipo test");
            String enunciado = Menu.pedirDato (sc, "el enunciado de la pregunta");
            switch(tipoPregunta){
                case "1" -> {
                    p = new PreguntaCorta (enunciado,1, Menu.pedirDato (sc, "La respuesta correcta de la pregunta"));
                    preguntas.put (cointador,p);
                    cointador++;
                }
                case "2" -> {
                    Map<Character, String> posiblesRespuestas =  establecerOpcionesPreguntaTest (sc);
                    System.out.println (posiblesRespuestas );
                    p = new PreguntaTipoTest (enunciado, 2,posiblesRespuestas,escogerRespuestaCorrectaParaTipoTest (sc));
                            preguntas.put (cointador, p);
                            cointador++;
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
    private static Map<Character, String> establecerOpcionesPreguntaTest(Scanner sc){
        Map<Character, String> posiblesRespuestas  = new TreeMap<> (  );
        char clave = 'a';
        boolean exit = false;
        do{
            String posibleRespuesta = pedirDato (sc, "una posible respuesta para la regunta");
            posiblesRespuestas.put (clave, posibleRespuesta);
            clave++;
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
        Map<Integer, Pregunta> preguntas = crearPreguntasDeUnTest (sc);
        return new Test (nombre, (TreeMap<Integer, Pregunta>) preguntas);
    }
}
