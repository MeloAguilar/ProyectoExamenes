package Main;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;
import Clases.Preguntas.PreguntaCorta;
import Clases.Preguntas.PreguntaTipoTest;
import Clases.Test.Test;
import Menu.Menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {


    private static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
      Test test = TestsDataAccess.reconstruirTest (TestsDataAccess.PATH+ "Mitestfachero.dat");
        System.out.println ( test );
    }


    private static Test crearTestNuevo() {
        Test test = Menu.crearNuevoTest (sc);
        TestsDataAccess.introducirTestEnFichero (test);
        System.out.println (test.getPreguntas ());
        return test;
    }
}
