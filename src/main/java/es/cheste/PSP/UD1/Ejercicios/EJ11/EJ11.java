package es.cheste.PSP.UD1.Ejercicios.EJ11;

import java.util.Scanner;

public class EJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu dni sin la letra: ");
        int dni = sc.nextInt();

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int nLetra = dni % 23;
        String letra = letras[nLetra] + "";

        String dniCompleto = String.valueOf(dni) + letra;

        System.out.println(dniCompleto);
    }
}
