package es.cheste.PSP.UD1.Ejercicios.EJ21;

import java.util.ArrayList;
import java.util.Scanner;

public class EJ21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaPersonas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce la persona nº"+(i+1)+": \n");
            listaPersonas.add(sc.nextLine());
        }

        System.out.println(listaPersonas);
    }
}
