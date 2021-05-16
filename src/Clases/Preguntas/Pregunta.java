package Clases.Preguntas;

import java.io.Serializable;

public class Pregunta implements Serializable {

    private String enunciado;
    private double puntuacion;

    public Pregunta(String enunciado, double puntuacion) {
        this.enunciado = enunciado;
        this.puntuacion = puntuacion;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "enunciado=" + enunciado +
                ", puntuacion=" + puntuacion;
    }
}
