package es.cheste.UD1_Ficheros.ModulosJSON;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Text;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModulosJSON {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args) {
        List<Personaje> personajes = deserializarJSON();
        List<Personaje> personajesNoVehiculo = personajesNoVehiculos(personajes);

        Collections.sort(personajesNoVehiculo);
        personajesNoVehiculo.forEach(System.out::println);

        if(ficheroXML(personajesNoVehiculo)){
            System.out.println("Se ha podido crear el fichero XML correctamente");

        } else{
            System.out.println("No se ha podido crear el fichero XML");
        }


    }

        public static List<Personaje> deserializarJSON() {

        Personajes personajes = new Personajes();

        try (FileReader reader = new FileReader("src/main/resources/UD1_Ficheros/ModulosJSON/SW.json")) {

            Gson gson = new Gson();

            personajes = gson.fromJson(reader, Personajes.class);
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return personajes.getPersonajes();
    }

    public static List<Personaje> personajesNoVehiculos(List<Personaje> personajes) {
        List<Personaje> personajesNoVehiculo = new ArrayList<>();

        for(Personaje personaje: personajes) {
            if (personaje.getVehicles().isEmpty()){
                personajesNoVehiculo.add(personaje);
            }
        }

        return personajesNoVehiculo;
    }

    public static boolean ficheroXML(List<Personaje> personajes) {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element characters = doc.createElement("characters");
            doc.appendChild(characters);

            for (Personaje personaje : personajes) {
                Element character = doc.createElement("character");
                character.setAttribute("films", personaje.getFilms().toString());
                character.setAttribute("vehicles", personaje.getVehicles().toString());

                Element name = doc.createElement("name");
                Text textoName = doc.createTextNode(personaje.getName());
                name.appendChild(textoName);
                character.appendChild(name);

                Element mass = doc.createElement("mass");
                Text textoMass = doc.createTextNode(personaje.getMass());
                mass.appendChild(textoMass);
                character.appendChild(mass);

                Element url = doc.createElement("url");
                Text textoUrl = doc.createTextNode(personaje.getUrl());
                url.appendChild(textoUrl);
                character.appendChild(url);

                characters.appendChild(character);
            }



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/main/resources/ModulosJSON/charactersNoVehiculo.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML generado correctamente.");


        } catch (ParserConfigurationException | TransformerException e) {
            LOGGER.error("Error a la hora de crear el fichero XML");
            return false;
        }


        return true;
    }

}
