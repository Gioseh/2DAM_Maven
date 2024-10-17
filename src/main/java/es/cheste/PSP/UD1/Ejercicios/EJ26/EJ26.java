package es.cheste.PSP.UD1.Ejercicios.EJ26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EJ26 {
    private static List<Double> suspensos = new ArrayList<Double>();
    private static List<Double> aprovados = new ArrayList<Double>();
    private static List<Double> notables = new ArrayList<Double>();
    private static List<Double> sobresalientes = new ArrayList<Double>();
    private static List<Double> matricula = new ArrayList<Double>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;


        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce una nota: ");
            a = sc.nextDouble();

            comprobarNota(a);

        }

        System.out.println("Suspensos: " + suspensos.toString());
        System.out.println("Aprovados: " + aprovados.toString());
        System.out.println("Notables: " + notables.toString());
        System.out.println("Sobresalientes: " + sobresalientes.toString());
        System.out.println("Matricula: " + matricula.toString());
    }

    private static void comprobarNota(double a) {
        if (a < 5) {
            suspensos.add(a);
        } else if (a < 7) {
            aprovados.add(a);
        } else if (a < 9) {
            notables.add(a);
        } else if (a < 10) {
            sobresalientes.add(a);
        } else if (a == 10) {
            matricula.add(a);
        }
    }
}
