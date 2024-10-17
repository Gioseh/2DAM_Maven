package es.cheste.PSP.UD1.Ejercicios.EJ3;

import java.util.Scanner;

public class EJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        int num = sc.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int num2 = sc.nextInt();

        int suma = num + num2;
        System.out.println("El resultado de la suma de num1: "+num+"y num2: "+num2+"es -> "+suma);
    }
}
