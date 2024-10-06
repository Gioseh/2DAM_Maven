package es.cheste.AD.UD1_Ficheros.Agenda;


import java.io.*;
import java.util.*;

import static es.cheste.AD.UD1_Ficheros.Agenda.LecturaEscrituraFicheros.escribirFicheros;
import static es.cheste.AD.UD1_Ficheros.Agenda.LecturaEscrituraFicheros.leerFicheros;
import static es.cheste.AD.UD1_Ficheros.Agenda.Menu.menuAgenda;
import static es.cheste.AD.UD1_Ficheros.Agenda.Menu.menuIdioma;

public class AplicacionAgenda {

    static Properties idioma = new Properties();
    static String filePathIdiomas;
    static String filePathAgendas = "src/main/resources/AD/UD1_Ficheros/Agenda/agendaContactos";
    static List<String> propiedades = new ArrayList<>();
    static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        Random random = new Random();

        escribirFicheros();
        agenda.setAgenda(leerFicheros(2));
        menuIdioma();
        menuAgenda();
    }

    public static void leerPropiedades() {
        try (InputStream input = new FileInputStream(filePathIdiomas)) {

            idioma.load(input);

            propiedades.add(idioma.getProperty("agradecimiento"));
            propiedades.add(idioma.getProperty("elegir.op.menu"));
            propiedades.add(idioma.getProperty("guardar.contacto"));
            propiedades.add(idioma.getProperty("modificar.contacto"));
            propiedades.add(idioma.getProperty("eliminar.contacto"));
            propiedades.add(idioma.getProperty("buscar.contacto"));
            propiedades.add(idioma.getProperty("mostrar.lista"));
            propiedades.add(idioma.getProperty("cerrar.app"));
            propiedades.add(idioma.getProperty("op.novalida"));
            propiedades.add(idioma.getProperty("nfe.menu"));
            propiedades.add(idioma.getProperty("nsee.menu"));
            propiedades.add(idioma.getProperty("nombre.mc"));
            propiedades.add(idioma.getProperty("apellidos.mc"));
            propiedades.add(idioma.getProperty("email.mc"));
            propiedades.add(idioma.getProperty("telf.mc"));
            propiedades.add(idioma.getProperty("direccion.mc"));
            propiedades.add(idioma.getProperty("ud.buscandoContacto"));
            propiedades.add(idioma.getProperty("campo.buscar"));
            propiedades.add(idioma.getProperty("direcc.buscar"));
            propiedades.add(idioma.getProperty("nadie.direccion"));
            propiedades.add(idioma.getProperty("telf.buscar"));
            propiedades.add(idioma.getProperty("nadie.telf"));
            propiedades.add(idioma.getProperty("email.buscar"));
            propiedades.add(idioma.getProperty("nadie.email"));
            propiedades.add(idioma.getProperty("apell.buscar"));
            propiedades.add(idioma.getProperty("nadie.apell"));
            propiedades.add(idioma.getProperty("nombre.buscar"));
            propiedades.add(idioma.getProperty("nadie.nombre"));
            propiedades.add(idioma.getProperty("ud.eliminandoContacto"));
            propiedades.add(idioma.getProperty("cont.eliminar"));
            propiedades.add(idioma.getProperty("ud.modificandoContacto"));
            propiedades.add(idioma.getProperty("cont.modificar"));
            propiedades.add(idioma.getProperty("modificar"));
            propiedades.add(idioma.getProperty("ins.modificar"));
            propiedades.add(idioma.getProperty("ud.creando"));
            propiedades.add(idioma.getProperty("form.crear"));

        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el archivo: " + filePathIdiomas);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo: " + filePathIdiomas);
        }
    }
}
