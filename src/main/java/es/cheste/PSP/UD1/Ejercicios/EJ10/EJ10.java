package es.cheste.PSP.UD1.Ejercicios.EJ10;

import java.util.Scanner;

public class EJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0;

        do {
            System.out.println("Introduce un numero del 1 al 12");
            a = sc.nextInt();

            if (a<1 || a>12){
                System.out.println("Error pusiste un valor menor a 1 o mayor a 12");
            }

        }while (a<1 || a>12);

        switch (a){
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;

        }

    }
}