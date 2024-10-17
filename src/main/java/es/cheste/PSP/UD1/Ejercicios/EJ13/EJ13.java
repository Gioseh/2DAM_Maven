package es.cheste.PSP.UD1.Ejercicios.EJ13;

import java.util.Scanner;

public class EJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los grados Celsius: \n");
        double gradosCentigrados = sc.nextDouble();

        System.out.printf("%.2f", calcularGradosFahrenheit(gradosCentigrados));

    }



    public static double calcularGradosFahrenheit(double gradosCelsius){
        return gradosCelsius+273.15;
    }


}
