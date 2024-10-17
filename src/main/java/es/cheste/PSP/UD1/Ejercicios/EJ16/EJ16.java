package es.cheste.PSP.UD1.Ejercicios.EJ16;

import java.util.Scanner;

public class EJ16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu fecha de nacimiento (formato:xx/xx/xxxx): \n");
        String fecha = sc.nextLine();

        System.out.println("" + calcularNumSuerte(fecha));

    }

    private static int calcularNumSuerte(String fecha) {
        String[] numeros = fecha.split("/");
        int numSuerte = 0;
        switch (numeros[0]) {
            case "01", "02", "03", "04", "05", "06", "07", "08", "09":
                numSuerte += 5;
                break;
            case "11", "12", "13", "14", "15", "16", "17", "18", "19":
                numSuerte += 15;
                break;
            case "21", "22", "23", "24", "25", "26", "27", "28", "29":
                numSuerte += 25;
                break;
            case "10","20","30", "31":
                numSuerte += 35;
                break;
        }

        if (Integer.parseInt(numeros[1]) % 2 == 0) {
            numSuerte += 5;
        } else {
            numSuerte -= 3;
        }


        if (Integer.parseInt(numeros[2]) % 2 != 0) {
            numSuerte += 100;
        } else {
            numSuerte -= 20;
        }

        return numSuerte;
    }
}
