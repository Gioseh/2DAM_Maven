package es.cheste.PSP.UD1.Ejercicios.EJ4;

import java.util.Scanner;

public class EJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        int num = sc.nextInt();

        System.out.println("Introduce el segundo numero: ");
        int num2 = sc.nextInt();

        if (num == num2) {
            System.out.println("Son iguales");
        } else if (num > num2) {
            System.out.println("Mayor-> " + num + "Menor-> " + num2);
        }else{
            System.out.println("Mayor-> " + num2 + "Menor-> " + num);
        }

    }
}
