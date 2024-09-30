package es.cheste.AD.UD1_Ficheros.ModulosDAM;

import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nombre;
    private String apellido;
    private List<Modulo> modulo;

    public Alumno(String nombre, String apellido, List<Modulo> modulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Modulo> getModulos() {
        return modulo;
    }

    public void setModulos(List<Modulo> modulo) {
        this.modulo = modulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(apellido, alumno.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", modulos=" + modulo +
                '}';
    }
}
