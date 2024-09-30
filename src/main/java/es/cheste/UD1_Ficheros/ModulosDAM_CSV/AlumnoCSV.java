package es.cheste.UD1_Ficheros.ModulosDAM_CSV;

import java.util.List;
import java.util.Objects;

public class AlumnoCSV {
    private String nombre;
    private String apellido;
    private List<ModuloCSV> moduloCSVS;

    public AlumnoCSV(String nombre, String apellido, List<ModuloCSV> moduloCSVS) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.moduloCSVS = moduloCSVS;
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

    public List<ModuloCSV> getModulos() {
        return moduloCSVS;
    }

    public void setModulos(List<ModuloCSV> moduloCSVS) {
        this.moduloCSVS = moduloCSVS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoCSV alumnoCSV = (AlumnoCSV) o;
        return Objects.equals(nombre, alumnoCSV.nombre) && Objects.equals(apellido, alumnoCSV.apellido);
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
                ", modulos=" + moduloCSVS +
                '}';
    }
}
