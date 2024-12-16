package es.cheste.PSP.UD2.Ejercicios.Entregables.ControlErroresValidacion;

import java.util.Scanner;

public class Sumador {
    static boolean datosValidos = true;

    public static void main(String[] args) {


        while(datosValidos){
            Sumador sumador = new Sumador();
        }

    }
    public Sumador() {
        int num1 = num1();
        int num2 = num2();

        if (validarDatos(num1, num2)) {
            System.out.println(sumar(num1(),num2()));
        }else{
            datosValidos = false;
        }

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

    public boolean validarDatos(int num1, int num2){

        if (num1>num2){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
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
