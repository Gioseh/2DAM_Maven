package es.cheste.DI.UD2.CalculadoraPro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogicaVentana implements ActionListener {

    private Ventana ventana;
    private String operacion = "";
    private double valorActual = 0;
    private double valorActual2 = 0;
    private double resultado = 0;
    private double valorGuardado = 0;


    public LogicaVentana(Ventana ventana) {
        this.ventana = ventana;
        agregarEventos();
    }

    private void agregarEventos() {
        for (int i = 0; i < ventana.botones.length; i++) {
            ventana.botones[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String textoPantalla = ventana.txtPantalla.getText();

        switch (comando) {
            case "MC":
                valorGuardado = 0;
                break;
            case "MR":
                ventana.txtPantalla.setText("" + valorGuardado);
                textoPantalla = "" + valorGuardado;
                break;
            case "M+":
                valorActual = Double.parseDouble(textoPantalla);
                ventana.txtPantalla.setText("");
                ventana.txtPantalla.setText("" + (valorActual + valorGuardado));
                valorActual = 0;
                break;
            case "MS":
                valorGuardado = Double.parseDouble(textoPantalla);
                break;
            case "CE":
                ventana.txtPantalla.setText("");
                valorActual2 = 0;
                break;
            case "C":
                ventana.txtPantalla.setText("");
                valorActual = 0;
                operacion = "";
                valorActual2 = 0;
                break;
            case "%":
                valorActual = Double.parseDouble(textoPantalla);
                ventana.txtPantalla.setText("" + (valorActual / 100));
                break;
            case "x2":
                valorActual = Double.parseDouble(textoPantalla);
                ventana.txtPantalla.setText("" + (Math.pow(valorActual,2)));
                break;
            case "1/x":
                valorActual = Double.parseDouble(textoPantalla);
                ventana.txtPantalla.setText("" + (1/valorActual));
                break;
            case "Raíz":
                valorActual = Double.parseDouble(textoPantalla);
                ventana.txtPantalla.setText("" + (Math.sqrt(valorActual)));
                break;

        }


        if (comando.matches("\\d")) {
            ventana.txtPantalla.setText(textoPantalla + comando);
        } else if (comando.matches("[+\\-*/]")) {
            valorActual = Double.parseDouble(textoPantalla);
            operacion = comando; // Guardar la operación actual
            ventana.txtPantalla.setText("");
        } else if (comando.equals("=")) {
            valorActual2 = Double.parseDouble(ventana.txtPantalla.getText());
            switch (operacion) {
                case "+" -> resultado = valorActual + valorActual2;
                case "-" -> resultado = valorActual - valorActual2;
                case "*" -> resultado = valorActual * valorActual2;
                case "/" -> resultado = valorActual / valorActual2;
            }
            ventana.txtPantalla.setText(String.valueOf(resultado));
        } else if (comando.equals(".")) {
            ventana.txtPantalla.setText(textoPantalla + ".");
        }
    }
}
