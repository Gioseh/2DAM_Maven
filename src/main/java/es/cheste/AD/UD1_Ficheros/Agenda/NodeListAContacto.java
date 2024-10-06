package es.cheste.AD.UD1_Ficheros.Agenda;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class NodeListAContacto {

    public static List<Contacto> convertirNodeListAContactos(NodeList nodeList) {
        List<Contacto> listaContactos = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodo = nodeList.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;

                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String apellidos = elemento.getElementsByTagName("apellidos").item(0).getTextContent();
                String email = elemento.getElementsByTagName("email").item(0).getTextContent();
                String telefono1 = elemento.getElementsByTagName("telefono1").item(0).getTextContent();
                String telefono2 = elemento.getElementsByTagName("telefono2").item(0).getTextContent();
                String direccion = elemento.getElementsByTagName("direccion").item(0).getTextContent();

                Contacto contacto = new Contacto(nombre, apellidos, email, telefono1, telefono2, direccion);

                listaContactos.add(contacto);
            }
        }

        return listaContactos;
    }

}
