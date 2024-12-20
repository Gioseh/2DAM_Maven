package es.cheste.PSP.UD2.Ejercicios.SumarNumeros;

import java.io.*;
import java.util.Scanner;

public class LanzadorProcesos {

    public void ejecutar(String ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java","-cp",".",ruta);
            Process proceso = pb.start();




            //Procesar salida
            java.io.InputStream is = proceso.getInputStream();
            java.io.InputStreamReader isr = new java.io.InputStreamReader(is);
            java.io.BufferedReader brHijo = new java.io.BufferedReader(isr);

            PrintStream ps = new PrintStream(proceso.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String linea;
            while ((linea = brHijo.readLine()) != null) {
                System.out.println(linea);
            }


            proceso.waitFor();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public static void main(String[] args) {


        LanzadorProcesos lp = new LanzadorProcesos();
        lp.ejecutar("Sumador.java");
        System.out.println("Finalizado");
    }
}
