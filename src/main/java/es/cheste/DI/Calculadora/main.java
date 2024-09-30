package es.cheste.DI.Calculadora;

public class main {


    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.iniciar();
        LogicaVentana logicaVentana = new LogicaVentana(ventana);
        ventana.setVisible(true);
    }
}
