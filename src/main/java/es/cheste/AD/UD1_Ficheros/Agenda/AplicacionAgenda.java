package es.cheste.AD.UD1_Ficheros.Agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class AplicacionAgenda {

    static Properties idioma = new Properties();
    static String filePath;
    static List<String> propiedades = new ArrayList<>();

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        menuIdioma();
        menuAgenda();
    }

    public static void menuIdioma() {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a tu nueva agenda!\nNecesitamos sabes con que idoma proceder, " +
                "introduzca una de estas opciones: \n(1) -> usar español como lenguaje por defecto" +
                "\n(2) -> usar valenciano como lenguaje por defecto \n(3) -> usar inglés como lenguaje por defecto");
        String opcionIdioma = sc.nextLine();

        switch (opcionIdioma) {
            case "1":
                filePath = "src/main/resources/AD/UD1_Ficheros/Agenda/agenda_es.properties";
                break;
            case "2":
                filePath = "src/main/resources/AD/UD1_Ficheros/Agenda/agenda_ca_es.properties";
                break;
            case "3":
                filePath = "agenda_en.properties";
                break;
        }

        leerPropiedades();

        sc.close();
    }

    public static void menuAgenda() {
        Scanner sc = new Scanner(System.in);

        System.out.println(propiedades.get(0) + "\n" + propiedades.get(1) +
                "\n(1) -> " + propiedades.get(2) +
                "\n(2) -> " + propiedades.get(3) +
                "\n(3) -> " + propiedades.get(4) +
                "\n(4) -> " + propiedades.get(5) +
                "\n(5) -> " + propiedades.get(6) +
                "\n(6) -> " + propiedades.get(7));
    }

    public static void leerPropiedades() {
        try(InputStream input = new FileInputStream(filePath)) {

            idioma.load(input);

            propiedades.add(idioma.getProperty("agradecimiento"));
            propiedades.add(idioma.getProperty("elegir.op.menu"));
            propiedades.add(idioma.getProperty("guardar.contacto"));
            propiedades.add(idioma.getProperty("eliminar.contacto"));
            propiedades.add(idioma.getProperty("modificar.contacto"));
            propiedades.add(idioma.getProperty("buscar.contacto"));
            propiedades.add(idioma.getProperty("mostrar.lista"));
            propiedades.add(idioma.getProperty("cerrar.app"));

        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el archivo: " + filePath);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo: " + filePath);
        }
    }
}
