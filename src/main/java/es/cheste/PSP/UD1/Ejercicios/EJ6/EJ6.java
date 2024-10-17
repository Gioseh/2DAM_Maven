package es.cheste.PSP.UD1.Ejercicios.EJ6;

import java.util.Scanner;

public class EJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce un numero");
            int number = sc.nextInt();
            suma += number;
        }

        System.out.println(suma);
    }
}
