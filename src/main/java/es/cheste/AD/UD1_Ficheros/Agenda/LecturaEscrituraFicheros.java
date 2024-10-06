package es.cheste.AD.UD1_Ficheros.Agenda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static es.cheste.AD.UD1_Ficheros.Agenda.AplicacionAgenda.filePathAgendas;

public class LecturaEscrituraFicheros {

    public static void escribirFicheros() {
        List<Contacto> contactosInventados = new ArrayList<>();
        contactosInventados.add(new Contacto("Carlos", "González Pérez", "carlos.gp@gmail.com", "+34 912345678", "+34 622345678", "Calle Mayor 12, Madrid"));
        contactosInventados.add(new Contacto("Laura", "Martínez López", "laura.ml@outlook.com", "+34 913456789", "+34 633456789", "Av. de la Paz 45, Valencia"));
        contactosInventados.add(new Contacto("José", "Fernández Ruiz", "josefr@gmail.com", "+34 914567890", "+34 644567890", "Calle del Sol 89, Barcelona"));
        contactosInventados.add(new Contacto("Ana", "García Sánchez", "ana.gs@hotmail.com", "+34 915678901", "+34 655678901", "Plaza del Carmen 23, Sevilla"));
        contactosInventados.add(new Contacto("Miguel", "Rodríguez Torres", "miguel.rt@yahoo.com", "+34 916789012", "+34 666789012", "Calle Larga 67, Bilbao"));
        contactosInventados.add(new Contacto("María", "Hernández Castro", "mariahc@gmail.com", "+34 917890123", "+34 677890123", "Av. Libertad 5, Zaragoza"));
        contactosInventados.add(new Contacto("Luis", "Jiménez Gómez", "luisjg@outlook.es", "+34 918901234", "+34 688901234", "Calle Real 34, Málaga"));
        contactosInventados.add(new Contacto("Beatriz", "López Morales", "bea.lopez@yahoo.es", "+34 919012345", "+34 699012345", "Paseo de Gracia 11, Barcelona"));
        contactosInventados.add(new Contacto("David", "Santos Martínez", "david.santos@gmail.com", "+34 910123456", "+34 600123456", "Calle del Prado 101, Madrid"));

        escribirFicheroCSV(contactosInventados);
        escribirFicheroXML(contactosInventados);
        escribirFicheroJSON(contactosInventados);
    }

    public static void actualizarFicheros(List<Contacto> contactos) {

        escribirFicheroCSV(contactos);
        escribirFicheroXML(contactos);
        escribirFicheroJSON(contactos);
    }

    private static void escribirFicheroJSON(List<Contacto> contactosInventados) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePathAgendas + ".json")) {
            gson.toJson(contactosInventados, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void escribirFicheroXML(List<Contacto> contactosInventados) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();

            Document document = domImpl.createDocument(null, "agenda", null);
            document.setXmlVersion("1.0");

            for (Contacto contacto : contactosInventados) {

                Element contactoElement = document.createElement("contacto");

                Element nombre = document.createElement("nombre");
                Text textoNombre = document.createTextNode(contacto.getNombre());
                nombre.appendChild(textoNombre);
                contactoElement.appendChild(nombre);

                Element apellidos = document.createElement("apellidos");
                Text textoApellidos = document.createTextNode(contacto.getApellidos());
                apellidos.appendChild(textoApellidos);
                contactoElement.appendChild(apellidos);

                Element email = document.createElement("email");
                Text textoEmail = document.createTextNode(contacto.getEmail());
                email.appendChild(textoEmail);
                contactoElement.appendChild(email);

                Element telefono1 = document.createElement("telefono1");
                Text textoTelefono1 = document.createTextNode(contacto.getEmail());
                telefono1.appendChild(textoTelefono1);
                contactoElement.appendChild(telefono1);

                Element telefono2 = document.createElement("telefono2");
                Text textoTelefono2 = document.createTextNode(contacto.getTelefono2());
                telefono2.appendChild(textoTelefono2);
                contactoElement.appendChild(telefono2);

                Element direccion = document.createElement("dirección");
                Text textoDireccion = document.createTextNode(contacto.getEmail());
                direccion.appendChild(textoDireccion);
                contactoElement.appendChild(direccion);

                document.getDocumentElement().appendChild(contactoElement);
            }


            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(filePathAgendas + ".xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void escribirFicheroCSV(List<Contacto> contactosInventados) {
        File file = new File(filePathAgendas + ".csv");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("nombre;apellidos;email;telefono1;telefono2;dirección" + "\n");//TODO

            for (Contacto contacto : contactosInventados) {
                bw.write(contacto.getNombre() + ";" + contacto.getApellidos() + ";" + contacto.getEmail() + ";" + contacto.getTelefono1() + ";" + contacto.getTelefono2() + ";" + contacto.getDireccion() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());//TODO
            e.printStackTrace();
        }

    }

    public static List<Contacto> leerFicheros(int opcion) {
        List<Contacto> contactos = null;
        switch (opcion) {
            case 1:
                contactos = leerCSV();
                break;
            case 2:
                contactos = leerXML();
                break;
            case 3:
                contactos = leerJSON();
                break;

        }

        return contactos;

    }

    private static List<Contacto> leerJSON() {

        List<Contacto> contactos = null;

        try (FileReader reader = new FileReader(filePathAgendas + ".json")) {

            Gson gson = new Gson();

            Type contactoListType = new TypeToken<List<Contacto>>() {
            }.getType();
            contactos = gson.fromJson(reader, contactoListType);

            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return contactos;

    }

    private static List<Contacto> leerXML() {
        List<Contacto> contactos = new ArrayList<>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File(filePathAgendas + ".xml");
            Document document = builder.parse(file);

            NodeList listaContactos = document.getElementsByTagName("contacto");
            List<String> datos = new ArrayList<>();
            for (int i = 0; i < listaContactos.getLength(); i++) {
                Node contacto = listaContactos.item(i);

                if (contacto.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) contacto;
                    NodeList hijos = element.getChildNodes();

                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);

                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element hijoElement = (Element) hijo;

                            datos.add(hijoElement.getTextContent());
                        }

                    }

                    contactos.add(new Contacto(datos.get(0), datos.get(1), datos.get(2), datos.get(3), datos.get(4), datos.get(5)));
                    datos.clear();
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return contactos;
    }

    private static List<Contacto> leerCSV() {
        File file = new File(filePathAgendas + ".csv");
        List<Contacto> contactos = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea = null;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] contacto = linea.split(";");
                contactos.add(new Contacto(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4], contacto[5]));
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error al escribir en el fichero: " + e.getMessage());//TODO
            e.printStackTrace();

        }

        return contactos;

    }

}
