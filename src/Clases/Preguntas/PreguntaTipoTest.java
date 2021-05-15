package Clases.Preguntas;

import java.io.Serializable;
import java.util.Map;

public class PreguntaTipoTest extends Pregunta implements Serializable {

    //Atributos
    private Map<Character, String> posiblesRespuestas;
    private char respuestaCorrecta;
    public static final long serialFilter = 1L;

    //Métodos

    //Constructor


    public PreguntaTipoTest(String enunciado, double puntuacion, Map<Character, String> posiblesRespuestas, char caracterRespuestaCorrecta) {
        super (enunciado, puntuacion);
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuestaCorrecta = caracterRespuestaCorrecta;
    }

    //Getters & Setters
    public Map<Character, String> getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    public void setPosiblesRespuestas(Map<Character, String> posiblesRespuestas) {
        this.posiblesRespuestas = posiblesRespuestas;
    }

    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(char respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public String toString() {
        return super.toString () +
                ", posiblesRespuestas=" + posiblesRespuestas +
                ", respuestaCorrecta=" + respuestaCorrecta +
                '}';
    }
}
