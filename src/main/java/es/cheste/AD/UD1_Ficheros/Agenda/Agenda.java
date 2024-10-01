package es.cheste.AD.UD1_Ficheros.Agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> agenda;

    public Agenda() {
        agenda = new ArrayList<Contacto>();
    }
    public List<Contacto> getAgenda() {
        return agenda;
    }
    public void setAgenda(List<Contacto> agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "agenda=" + agenda +
                '}';
    }
}
