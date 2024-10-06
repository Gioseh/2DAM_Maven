package es.cheste.AD.UD1_Ficheros.Agenda;


import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static es.cheste.AD.UD1_Ficheros.Agenda.AplicacionAgenda.agenda;
import static es.cheste.AD.UD1_Ficheros.Agenda.AplicacionAgenda.propiedades;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public static void menuIdioma() {

        System.out.println("¡Bienvenido a tu nueva agenda!\nNecesitamos sabes con que idoma proceder, " +
                "introduzca una de estas opciones: \n(1) -> usar español como lenguaje por defecto" +
                "\n(2) -> usar valenciano como lenguaje por defecto \n(3) -> usar inglés como lenguaje por defecto");
        String opcionIdioma = sc.nextLine();

        switch (opcionIdioma) {
            case "1":
                AplicacionAgenda.filePathIdiomas = "src/main/resources/AD/UD1_Ficheros/Agenda/agenda_es.properties";
                break;
            case "2":
                AplicacionAgenda.filePathIdiomas = "src/main/resources/AD/UD1_Ficheros/Agenda/agenda_ca_es.properties";
                break;
            case "3":
                AplicacionAgenda.filePathIdiomas = "agenda_en.properties";
                break;
        }

        AplicacionAgenda.leerPropiedades();

    }

    public static void menuAgenda() {

        String opcionMenuAgenda;
        do {

            System.out.println(propiedades.get(0) + "\n" + propiedades.get(1) +
                    "\n(1) -> " + propiedades.get(2) +
                    "\n(2) -> " + propiedades.get(3) +
                    "\n(3) -> " + propiedades.get(4) +
                    "\n(4) -> " + propiedades.get(5) +
                    "\n(5) -> " + propiedades.get(6) +
                    "\n(6) -> " + propiedades.get(7));


            try {
                opcionMenuAgenda = sc.nextLine();
                int opcion = Integer.parseInt(opcionMenuAgenda);

                switch (opcion) {
                    case 1:
                        guardarContacto();
                        break;
                    case 2:
                        modificarContacto();
                        break;
                    case 3:
                        eliminarContacto();
                        break;
                    case 4:
                        buscarContacto();
                        break;
                    case 5:
                        mostrarContactos();
                        break;
                    case 6:
                        cerrarApp();
                        break;
                    default:
                        System.out.println(propiedades.get(8));//op.novalida
                }
            } catch (NumberFormatException e) {
                System.out.println(propiedades.get(9));//nfe.menu
            } catch (NoSuchElementException e) {
                System.out.println(propiedades.get(10));//nsee.menu
                break;
            }
        } while (true);
    }

    private static void cerrarApp() {
        System.exit(0);
    }

    private static void mostrarContactos() {
        Collections.sort(agenda.getAgenda());
        System.out.println("--------------");
        for (Contacto contacto : agenda.getAgenda()) {
            StringBuilder sb = new StringBuilder();
            sb.append(contacto.getNombre()+" "+contacto.getApellidos()+"\n");
            sb.append("\t"+ propiedades.get(13)+": "+contacto.getEmail()+"\n");//email.mc
            sb.append("\t"+propiedades.get(14)+"1: "+contacto.getTelefono1()+"\n");//telf.mc
            sb.append("\t"+propiedades.get(14)+"2: "+contacto.getTelefono2()+"\n");//telf.mc
            sb.append("\t"+propiedades.get(15)+": "+contacto.getDireccion()+"\n");
            System.out.println(sb.toString());
        }
    }

    private static void buscarContacto() {

        String campoBuscar = null;
        boolean campoExiste = Boolean.FALSE;

        do {
            System.out.println(propiedades.get(16)+//ud.buscandoContacto
                    propiedades.get(17));//campo.buscar

            for (int i = 0; i < agenda.getAgenda().size(); i++) {
                System.out.println((i) + ") " + agenda.getAgenda().get(i));
            }
            campoBuscar = sc.nextLine().toLowerCase();

            switch (campoBuscar) {
                case "nombre"://nombre.mc
                    campoExiste = Boolean.TRUE;

                    buscarNombre();
                    break;
                case "apellidos"://apellidos.mc
                    campoExiste = Boolean.TRUE;

                    buscarApellido();
                    break;
                case "email"://email.mc
                    campoExiste = Boolean.TRUE;

                    buscarEmail();
                    break;
                case "telefono1", "telefono2"://telf.mc
                    campoExiste = Boolean.TRUE;

                    buscarTelefono();
                    break;
                case "direccion"://direccion.mc
                    campoExiste = Boolean.TRUE;

                    buscarDireccion();
                    break;
            }
        } while (!campoExiste);

    }

    private static void buscarDireccion() {
        boolean direccionExiste = Boolean.FALSE;

        System.out.println(propiedades.get(18));//direcc.buscar
        String direccion = sc.nextLine();

        for (Contacto contacto : agenda.getAgenda()) {
            if (contacto.getDireccion().equals(direccion)) {
                System.out.println(contacto);
                direccionExiste = Boolean.TRUE;
                break;
            }
        }

        if (!direccionExiste) {
            System.out.println(propiedades.get(19)+ direccion);//nadie.direccion
        }
    }

    private static void buscarTelefono() {
        boolean telefonoExiste = Boolean.FALSE;


        System.out.println(propiedades.get(20));//telf.buscar
        String telefono = sc.nextLine();

        for (Contacto contacto : agenda.getAgenda()) {
            if (contacto.getTelefono1().equals(telefono)) {
                System.out.println(contacto);
                telefonoExiste = Boolean.TRUE;
                break;
            }

            if (contacto.getTelefono2().equals(telefono)) {
                System.out.println(contacto);
                telefonoExiste = Boolean.TRUE;
            }
        }

        if (!telefonoExiste) {
            System.out.println(propiedades.get(21) + telefono);//nadie.telf
        }
    }

    private static void buscarEmail() {
        boolean emailExiste = Boolean.FALSE;


        System.out.println(propiedades.get(22));//email.buscar
        String email = sc.nextLine();

        for (Contacto contacto : agenda.getAgenda()) {
            if (contacto.getEmail().equals(email)) {
                System.out.println(contacto);
                emailExiste = Boolean.TRUE;
                break;
            }
        }

        if (!emailExiste) {
            System.out.println(propiedades.get(23) + email);//nadie.email
        }
    }

    private static void buscarApellido() {
        boolean apellidoExiste = Boolean.FALSE;

        System.out.println(propiedades.get(24));//apell.buscar
        String apellido = sc.nextLine();

        for (Contacto contacto : agenda.getAgenda()) {
            if (contacto.getApellidos().equals(apellido)) {
                System.out.println(contacto);
                apellidoExiste = Boolean.TRUE;
                break;
            }
        }

        if (!apellidoExiste) {
            System.out.println(propiedades.get(25) + apellido);//nadie.apell
        }
    }

    private static void buscarNombre() {

        boolean nombreExiste = Boolean.FALSE;


        System.out.println(propiedades.get(26));//nombre.buscar
        String nombre = sc.nextLine();

        for (Contacto contacto : agenda.getAgenda()) {
            if (contacto.getNombre().equals(nombre)) {
                System.out.println(contacto);
                nombreExiste = Boolean.TRUE;
                break;
            }
        }

        if (!nombreExiste) {
            System.out.println(propiedades.get(27) + nombre);//nadie.nombre
        }

    }


    private static void eliminarContacto() {
        String contactoEliminar = null;

        do {
            System.out.println(propiedades.get(28) +
                    propiedades.get(29));//cont.eliminar

            for (int i = 0; i < agenda.getAgenda().size(); i++) {
                System.out.println((i) + ") " + agenda.getAgenda().get(i));
            }
            contactoEliminar = sc.nextLine();

        } while (!agenda.getAgenda().contains(agenda.getAgenda().get(Integer.parseInt(contactoEliminar))));


        List<Contacto> contactosModificados = agenda.getAgenda();
        contactosModificados.remove(Integer.parseInt(contactoEliminar));
        agenda.setAgenda(contactosModificados);

        LecturaEscrituraFicheros.actualizarFicheros(agenda.getAgenda());
    }

    private static void modificarContacto() {
        String contactoModificar = null;

        do {
            System.out.println(propiedades.get(30) +//ud.modificandoContacto
                    propiedades.get(31));//cont.modificar

            for (int i = 0; i < agenda.getAgenda().size(); i++) {
                System.out.println((i) + ") " + agenda.getAgenda().get(i));
            }
            contactoModificar = sc.nextLine();

        } while (!agenda.getAgenda().contains(agenda.getAgenda().get(Integer.parseInt(contactoModificar))));

        System.out.println(propiedades.get(32)+" " + contactoModificar + ":\n" +//modificar
                propiedades.get(33));//ins.modificar
        String[] datosModificados = sc.nextLine().split(";");

        List<Contacto> contactosModificados = agenda.getAgenda();

        for (int i = 0; i < 6; i++) {
            if (!datosModificados[i].equals("-")) {
                switch (i) {
                    case 0:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setNombre(datosModificados[i]);
                        break;
                    case 1:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setApellidos(datosModificados[i]);
                        break;
                    case 2:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setEmail(datosModificados[i]);
                        break;
                    case 3:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setTelefono1(datosModificados[i]);
                        break;
                    case 4:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setTelefono2(datosModificados[i]);
                        break;
                    case 5:
                        contactosModificados.get(Integer.parseInt(contactoModificar)).setDireccion(datosModificados[i]);
                        break;
                }
            }

        }

        agenda.setAgenda(contactosModificados);

        LecturaEscrituraFicheros.actualizarFicheros(agenda.getAgenda());
    }

    private static void guardarContacto() {

        String[] datosContacto = null;

        do {
            System.out.println(propiedades.get(34) +//ud.creando
                    "");
            String lineaContacto = sc.nextLine();
            datosContacto = lineaContacto.split(";");
        } while (datosContacto.length != 6);

        List<Contacto> copia = agenda.getAgenda();
        copia.add(new Contacto(datosContacto[0], datosContacto[1], datosContacto[2], datosContacto[3], datosContacto[4], datosContacto[5]));
        agenda.setAgenda(copia);

        LecturaEscrituraFicheros.actualizarFicheros(agenda.getAgenda());
    }
}
