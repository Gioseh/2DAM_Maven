package es.cheste.AD.UD1_Ficheros.Agenda;

import java.util.List;
import java.util.Objects;

public class Agenda {
    private List<Contacto> agenda;

    public Agenda() {
        super();
    }
    public List<Contacto> getAgenda() {
        return agenda;
    }
    public void setAgenda(List<Contacto> agenda) {
        this.agenda = agenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda1 = (Agenda) o;
        return Objects.equals(agenda, agenda1.agenda);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(agenda);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "agenda=" + agenda +
                '}';
    }
}
