package Clases.Preguntas;

import java.io.Serializable;

public class PreguntaCorta extends Pregunta implements Serializable {

    //Atributos
    private String respuestaCorrecta;
    public static final long serialVersionUID = 1L;
    //Métodos

    //Constructor

    public PreguntaCorta(String enunciado, double puntuacion, String respuestaCorrecta) {
        super (enunciado, puntuacion);
        this.respuestaCorrecta = respuestaCorrecta;
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public String toString() {
        return super.toString () +
                ", respuestaCorrecta=" + respuestaCorrecta +
                '}';
    }
}
