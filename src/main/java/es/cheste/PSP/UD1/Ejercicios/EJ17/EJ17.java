package es.cheste.PSP.UD1.Ejercicios.EJ17;

import java.util.Scanner;

public class EJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean contrasenaCorrecta = Boolean.FALSE;

        do {
            System.out.println("Introuce la contraseña (Necesita 5 caracteres, 1 mayúscula y 1 numero): \n");
            String contrasena = sc.nextLine();

            if (contrasenaFuerte(contrasena)) {
                contrasenaCorrecta = Boolean.TRUE;
            }

        } while (!contrasenaCorrecta);

        System.out.println("Contraseña correcta");

    }

    private static boolean contrasenaFuerte(String contrasena) {
        int mayuscula = 0;
        int numero = 0;

        if (contrasena.length() >= 5) {
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isDigit(contrasena.charAt(i))) {
                    numero++;
                } else{
                    if (Character.isUpperCase(contrasena.charAt(i))) {
                        mayuscula++;
                    }
                }


                if (mayuscula >= 1 && numero >= 1) {
                    return Boolean.TRUE;
                }
            }
        } else {
            System.out.println("Hace falta que la contraseña tenga minimo 5 caracteres");
            return Boolean.FALSE;
        }

        if (mayuscula < 1) {
            System.out.println("Hace falta que la contraseña tenga al menos 1 mayúscula");
        }
        if (numero < 1) {
            System.out.println("Hace falta que la contraseña tenga al menos 1 numero");
        }

        return Boolean.FALSE;
    }
}
