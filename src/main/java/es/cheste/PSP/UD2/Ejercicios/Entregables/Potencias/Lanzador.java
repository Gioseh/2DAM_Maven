import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanzador {

    // Método para lanzar un proceso de suma en un rango específico y guardarlo en un archivo
    public void lanzarProceso(int base, int exponente, String archivoSalida) {
        ProcessBuilder pb = new ProcessBuilder("java", "Potencia", String.valueOf(base), String.valueOf(exponente), archivoSalida);
        pb.directory(new File("."));

        try {
            Process proceso = pb.start();
            proceso.waitFor(); // Esperar a que el proceso termine
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para leer el valor del archivo de salida
    public double leerResultado(String archivo) {
        double resultado = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();
            if (linea != null) {
                resultado = Double.parseDouble(linea.trim());
            } else {
                System.out.println("El archivo está vacío: " + archivo);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
        return resultado;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lanzador lanzador = new Lanzador();
        List<String> archivosSalida = new ArrayList<>();
        int resultado = 0;

        // Definir los rangos y nombres de archivos para cada proceso

        int exponenteActual = 2;
        int baseActual = 0;

        for (int i = 0; i < 3; i++) {
            String archivoSalida = "potencia_" + exponenteActual + ".txt";
            File archivoSalidaFile = new File(archivoSalida);

            try {
                if (archivoSalidaFile.createNewFile()) {
                    System.out.println("Archivo creado: " + archivoSalidaFile.getName());
                } else {
                    System.out.println("El archivo ya existe.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error.");
                e.printStackTrace();
            }

            archivosSalida.add(archivoSalida);


            System.out.println("Introduce la base del exponente="+exponenteActual+" : ");
            baseActual = sc.nextInt();

            // Lanzar un proceso Sumador para cada rango
            lanzador.lanzarProceso(exponenteActual, baseActual, archivoSalida);

            // Actualizar el inicio del próximo rango
            exponenteActual ++;
        }


        int exponente = 2;
        // Leer los resultados de los archivos y calcular la suma total
        for (String archivo : archivosSalida) {

            System.out.println("El resultado de la base^"+exponente + ": " +lanzador.leerResultado(archivo));
            exponente++;
        }

    }
}
