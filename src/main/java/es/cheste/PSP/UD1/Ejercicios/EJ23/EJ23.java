package es.cheste.PSP.UD1.Ejercicios.EJ23;

import java.util.ArrayList;
import java.util.Scanner;

public class EJ23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaPersonas = new ArrayList<>();
        String linea = null;
        int contador = 1;

        do {

            System.out.println("Introduce la persona nº"+contador+": \n");
            linea = sc.nextLine();

            if (!linea.equals("0")){
                listaPersonas.add(linea);
            }


        }while (!linea.equals("0"));

        listarPersonas(listaPersonas);
    }

    private static void listarPersonas(ArrayList<String> listaPersonas) {
        int contador = 1;

        for (String persona : listaPersonas) {
            System.out.println(contador+": "+persona);
            contador++;
        }
    }


}
