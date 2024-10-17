package es.cheste.PSP.UD1.Ejercicios.EJ15;

import java.util.Scanner;

public class EJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor del radio de la circumferencia: \n");
        double rad = sc.nextDouble();


        System.out.printf("Diametro: %.2f",calcularDiametro(rad));
        System.out.println();
        System.out.printf("Area: %.2f",calcularArea(rad));
        System.out.println();
        System.out.printf("Volumen esfera: %.2f",calcularVolumenEsfera(rad));
    }

    private static Double calcularArea(double rad) {
        return Math.PI * rad * rad;
    }

    private static double calcularDiametro(double rad) {
        return rad * 2;
    }

    private static double calcularVolumenEsfera(double rad) {
        return 4/3.0 * Math.PI * Math.pow(rad, 3);
    }
}
