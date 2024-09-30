package es.cheste.UD1_Ficheros.ModulosDAM_CSV;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ModulosDamCSV {
    final static String FICHERO_CSV = "src/main/resources/UD1_Ficheros/ModulosDAM_CSV/";

    public static void main(String[] args) {
        String[] modulos = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
        int[] horas = {6, 3, 6, 5, 5, 3};
        double[] notas = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};

        AlumnoCSV alumnoCSV = new AlumnoCSV("Sergio", "Rosa", crearModulosCSV(modulos, horas, notas));
        escribirFicheroCSV(alumnoCSV);
        System.out.println(leerFichero(alumnoCSV));
    }

    public static List<ModuloCSV> crearModulosCSV(String[] nombres, int[] horas, double[] notas) {
        List<ModuloCSV> moduloCSVS = new ArrayList<>();

        for (int i = 0; i < nombres.length; i++) {
            moduloCSVS.add(new ModuloCSV(nombres[i], horas[i], notas[i]));
        }

        return moduloCSVS;
    }

    public static void escribirFicheroCSV(AlumnoCSV alumnoCSV) {

        File file = new File(FICHERO_CSV + alumnoCSV.getNombre() + ".csv");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("nombre;horas;notas" + "\n");

            for (ModuloCSV moduloCSV : alumnoCSV.getModulos()) {
                bw.write(moduloCSV.getNombre() + ";" + moduloCSV.getHoras() + ";" + moduloCSV.getNotas() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static String leerFichero(AlumnoCSV alumnoCSV) {
        File file = new File(FICHERO_CSV + alumnoCSV.getNombre() + ".csv");

        String texto = new String();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea = null;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] alumno = linea.split(";");
                texto += alumno[0] + " ->  horas: " + alumno[1] + ", nota: " + alumno[2] + "\n------------------------------------------------------------------\n";
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error al escribir en el fichero: " + e.getMessage());
            e.printStackTrace();

        } finally {
            File fileCopia =  new File(FICHERO_CSV + alumnoCSV.getNombre() + "Copia.csv");

            if (fileCopia.exists()) {
                fileCopia.delete();
            }

            Path original = Paths.get(FICHERO_CSV + alumnoCSV.getNombre() + ".csv");
            Path copia = Paths.get(FICHERO_CSV + alumnoCSV.getNombre() + "Copia.csv");

            try {

                Files.copy(original, copia, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copia realizada correctamente.");
            } catch (IOException e) {
                System.out.println("Error al copiar el archivo: " + e.getMessage());
                e.printStackTrace();
            }

            file.delete();
        }

        return texto.toString();
    }


}
