package es.cheste.PSP.UD1.Ejercicios.EJ24;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<String> listaRecompensas = new ArrayList<>();
        listaRecompensas.add("PS5");
        listaRecompensas.add("XBOX Series X");
        listaRecompensas.add("Nintendo Switch");

        int numUsu;
        int numMaq;

        do {
            System.out.println("Introduce un numero del 1 al 10: ");
            numUsu = sc.nextInt();
            numMaq = (rand.nextInt(10) + 1);

            System.out.println("Num usu: " + numUsu);
            System.out.println("Num maquina: " + numMaq);
        } while (numUsu != numMaq);


        System.out.println("Has acertado, elige una de las recompensas: \n");
        listarRecompensas(listaRecompensas);
        sc.nextLine();
        int numRecompensa = sc.nextInt();
        System.out.println("Toma tu premio ("+listaRecompensas.get(numRecompensa-1)+")");

    }

    private static void listarRecompensas(ArrayList<String> listaRecompensas) {
        int contador = 1;

        for (String recompensa : listaRecompensas) {
            System.out.println(contador + ": " + recompensa);
            contador++;
        }
    }
}
