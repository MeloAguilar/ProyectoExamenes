package Clases.Test;

import Clases.AccesoADatos.TestsDataAccess;
import Clases.Preguntas.Pregunta;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.TreeMap;

public class Test implements Serializable {

    private String nombre;
    private File ficheroTest;
    private TreeMap<Integer, Pregunta> preguntas;
    public static final long serialFilter = 2L;


    public Test(String nombre, TreeMap<Integer, Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
        ficheroTest = new File (TestsDataAccess.PATH+ nombre+TestsDataAccess.EXTENSION);
        try {
            ficheroTest.createNewFile ( );
        }catch(IOException e){
        }
    }

    public String getNombre() {
        return nombre;
    }

    public File getFicheroTest() {
        return ficheroTest;
    }

    public void setFicheroTest(File ficheroTest) {
        this.ficheroTest = ficheroTest;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TreeMap<Integer, Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(TreeMap<Integer, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return nombre + ", preguntas=" + preguntas + '}';
    }
}
