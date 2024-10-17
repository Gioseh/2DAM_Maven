package es.cheste.PSP.UD1.Ejercicios.EJ12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        List<Double> suspensos = new ArrayList<Double>();
        List<Double> aprovados = new ArrayList<Double>();
        List<Double> notables = new ArrayList<Double>();
        List<Double> sobresalientes = new ArrayList<Double>();
        List<Double> matricula = new ArrayList<Double>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce una nota: ");
            a = sc.nextDouble();

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

        System.out.println("Suspensos: " + suspensos.toString());
        System.out.println("Aprovados: " + aprovados.toString());
        System.out.println("Notables: " + notables.toString());
        System.out.println("Sobresalientes: " + sobresalientes.toString());
        System.out.println("Matricula: " + matricula.toString());
    }
}
