package es.cheste.PSP.UD2.Ejercicios.SumarNumeros;

import java.util.Scanner;

public class Sumador {
    public static void main(String[] args) {
        Sumador sumador = new Sumador();
    }
    public Sumador() {


        //System.out.println(sumar(Integer.parseInt(num1()), num2()));
        System.out.println(sumar(num1(),num2()));
    }


    public int num1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 1 numero: ");
        return sc.nextInt();

    }

    public int num2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 2 numero: ");
       return sc.nextInt();
    }

    public int sumar(int a, int b) {
        int sumatorio = 0;
        while(a<=b){
            sumatorio += a;
            a++;
        }

        return sumatorio;
    }
}
