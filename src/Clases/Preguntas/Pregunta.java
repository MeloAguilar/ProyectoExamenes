package Clases.Preguntas;

import java.io.Serializable;

public abstract class Pregunta implements Serializable {
    //Atributos
    private String enunciado;
    private double puntuacion;
    public static final long serialFilter = 1L;
    //Métodos


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
                "enunciado='" + enunciado + '\'' +
                ", puntuacion=" + puntuacion;
    }
}
