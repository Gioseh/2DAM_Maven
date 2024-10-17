package es.cheste.PSP.UD1.Ejercicios.EJ14;

import java.util.Scanner;

public class EJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor del radio de la circumferencia: \n");
        double rad = sc.nextDouble();


        System.out.printf("Diametro: %.2f",calcularDiametro(rad));
        System.out.println();
        System.out.printf("Area: %.2f",calcularArea(rad));
    }

    private static Double calcularArea(double rad) {
        return Math.PI * rad * rad;
    }

    private static double calcularDiametro(double rad) {
        return rad * 2;
    }


}
