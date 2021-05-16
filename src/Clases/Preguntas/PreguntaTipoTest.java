package Clases.Preguntas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PreguntaTipoTest extends Pregunta implements Serializable {

    //Atributos
    private List<String> posiblesRespuestas;
    private char respuestaCorrecta;

    //Métodos

    //Constructor


    public PreguntaTipoTest(String enunciado, double puntuacion, List<String> posiblesRespuestas, char caracterRespuestaCorrecta) {
        super (enunciado, puntuacion);
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuestaCorrecta = caracterRespuestaCorrecta;
    }

    //Getters & Setters
    public List< String> getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    public void setPosiblesRespuestas(List<String> posiblesRespuestas) {
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
