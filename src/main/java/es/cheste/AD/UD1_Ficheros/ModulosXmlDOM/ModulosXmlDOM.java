package es.cheste.AD.UD1_Ficheros.ModulosXmlDOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModulosXmlDOM {

    final static String RUTA_FICHERO_XML = "src/main/resources/AD/UD1_Ficheros/ModulosXmlDOM/modulosSergio.xml";
    final static String[] MODULOS = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
    final static int[] HORAS = {6, 3, 6, 5, 5, 3};
    final static double[] NOTAS = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};

    public static void main(String[] args) {

        crearFicheroXml();
        leerXML();

    }


    public static void leerXML() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File(RUTA_FICHERO_XML);
            Document document = builder.parse(file);

            NodeList listaModulos = document.getElementsByTagName("modulo");

            for (int i = 0; i < listaModulos.getLength(); i++) {

                Element element = (Element) listaModulos.item(i);

                StringBuilder sb = new StringBuilder();

                sb.append(element.getNodeName());
                sb.append("Nom: " + element.getElementsByTagName("nombre").
                        item(0).getFirstChild().getNodeValue() + "\n");

                sb.append("Hores: " + element.getElementsByTagName("horasMod")
                        .item(0).getFirstChild().getNodeValue() + "\n");

                sb.append("Notas: " + element.getElementsByTagName("calificacion")
                        .item(0).getFirstChild().getNodeValue() + "\n");

                sb.append("---------------------------------------------------\n");


                System.out.println(sb.toString());

            }

        } catch (ParserConfigurationException | SAXException |
                 IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }


    public static void crearFicheroXml() {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();

            Document document = domImpl.createDocument(null, "curso", null);
            document.setXmlVersion("1.0");

            for (int i = 0; i < MODULOS.length; i++) {

                Element modulo = document.createElement("modulo");
                Element nombre = document.createElement("nombre");
                Text textoNombre = document.createTextNode(MODULOS[i]);
                nombre.appendChild(textoNombre);
                modulo.appendChild(nombre);

                Element horasMod = document.createElement("horasMod");
                Text textoHora = document.createTextNode("" + HORAS[i]);
                horasMod.appendChild(textoHora);
                modulo.appendChild(horasMod);

                Element calificacion = document.createElement("calificacion");
                Text textoCalificacion = document.createTextNode("" + NOTAS[i]);
                calificacion.appendChild(textoCalificacion);
                modulo.appendChild(calificacion);


                document.getDocumentElement().appendChild(modulo);

            }


            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(RUTA_FICHERO_XML));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
