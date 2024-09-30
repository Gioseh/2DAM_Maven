package es.cheste.AD.UD1_Ficheros.ModulosDAM;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Modulos {
    public static void main(String[] args) {
        String[] modulos = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
        int[] horas = {6, 3, 6, 5, 5, 3};
        double[] notas = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};

        Alumno alumno = new Alumno("Sergio", "Rosa", crearModulos(modulos, horas, notas));
        escribirFichero(alumno);
        System.out.println(leerFichero(alumno));
    }

    public static List<Modulo> crearModulos(String[] nombres, int[] horas, double[] notas) {
        List<Modulo> modulo = new ArrayList<>();

        for (int i = 0; i < nombres.length; i++) {
            modulo.add(new Modulo(nombres[i], horas[i], notas[i]));
        }

        return modulo;
    }

    public static void escribirFichero(Alumno alumno) {

        File file = new File("src/main/resources/UD1_Ficheros/ModulosDAM/modulos" + alumno.getNombre() + ".txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (Modulo modulo : alumno.getModulos()) {
                bw.write(modulo.getNombre() + " ->  horas: " + modulo.getHoras() + ", nota: " + modulo.getNotas() +
                        "\n------------------------------------------------------------------\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static String leerFichero(Alumno alumno) {
        File file = new File("src/main/resources/UD1_Ficheros/ModulosDAM/modulos" + alumno.getNombre() + ".txt");
        StringBuilder texto = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea = null;

            while ((linea = br.readLine()) != null) {
                texto.append(linea + "\n");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (!new File("src/main/resources/UD1_Ficheros/ModulosDAM/modulos" + alumno.getNombre() + "Copia.txt").exists()) {
                Path original = Paths.get( "src/main/resources/UD1_Ficheros/ModulosDAM/modulos"+ alumno.getNombre() + ".txt");
                Path copia = Paths.get("src/main/resources/UD1_Ficheros/ModulosDAM/modulos" + alumno.getNombre() + "Copia.txt");

                try {

                    Files.copy(original, copia);

                } catch (IOException e) {

                    System.out.println("Error al copiar el fichero: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            file.delete();
        }

        return texto.toString();
    }


}
