package es.cheste.PSP.UD1.Ejercicios.EJ7;

import java.util.Scanner;

public class EJ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int i = 0;
        do {
            System.out.println("Introduce un numero");
            int number = sc.nextInt();
            suma += number;
            i++;
        } while (i <= 4);

        System.out.println(suma);

    }
}
