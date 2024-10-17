package es.cheste.PSP.UD1.Ejercicios.EJ5;

import java.util.Scanner;

public class EJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        do {
            System.out.println("Ingrese el primer numero");
            num1 = sc.nextInt();
            System.out.println("Ingrese el segundo numero");
            num2 = sc.nextInt();
        }while (num1!=num2);
    }
}
