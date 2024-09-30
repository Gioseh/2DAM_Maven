package es.cheste.UD1_Ficheros.ModulosDAM;

import java.util.Objects;

public class Modulo {
    private String nombre;
    private int horas;
    private double notas;

    public Modulo(String nombre, int horas, double notas) {
        this.nombre = nombre;
        this.horas = horas;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(nombre, modulo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "nombre='" + nombre + '\'' +
                ", horas=" + horas +
                ", notas=" + notas +
                '}';
    }
}
