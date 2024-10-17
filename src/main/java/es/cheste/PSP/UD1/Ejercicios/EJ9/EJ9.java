package es.cheste.PSP.UD1.Ejercicios.EJ9;

import java.util.Random;

public class EJ9 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numAleatorio = rand.nextInt(11)+1;

        if (numAleatorio == 1) {
            System.out.println("Enero");
        }else if (numAleatorio == 2) {
            System.out.println("Febrero");
        }else if (numAleatorio == 3) {
            System.out.println("Marzo");
        }else if (numAleatorio == 4) {
            System.out.println("Abril");
        }else if (numAleatorio == 5) {
            System.out.println("Mayo");
        }else if (numAleatorio == 6) {
            System.out.println("Junio");
        }else if (numAleatorio == 7) {
            System.out.println("Julio");
        }else if (numAleatorio == 8) {
            System.out.println("Agosto");
        }else if (numAleatorio == 9) {
            System.out.println("Septiembre");
        }else if (numAleatorio == 10) {
            System.out.println("Octubre");
        }else if (numAleatorio == 11) {
            System.out.println("Noviembre");
        }else{
            System.out.println("Diciembre");
        }
    }
}
