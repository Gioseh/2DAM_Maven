package es.cheste.DI.UD2.Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogicaVentana implements ActionListener {

    private Ventana ventana;
    private String operacion = "";
    private double valorActual = 0;
    private double resultado = 0;

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


        if (comando.matches("\\d")) {
            ventana.txtPantalla.setText(textoPantalla + comando);
        }

        else if (comando.matches("[+\\-*/]")) {
            valorActual = Double.parseDouble(textoPantalla);
            operacion = comando; // Guardar la operación actual
            ventana.txtPantalla.setText("");
        }

        else if (comando.equals("=")) {
            double segundoValor = Double.parseDouble(ventana.txtPantalla.getText());
            switch (operacion) {
                case "+" -> resultado = valorActual + segundoValor;
                case "-" -> resultado = valorActual - segundoValor;
                case "*" -> resultado = valorActual * segundoValor;
                case "/" -> resultado = valorActual / segundoValor;
            }
            ventana.txtPantalla.setText(String.valueOf(resultado));
        }
        else if (comando.equals(".")) {
            ventana.txtPantalla.setText(textoPantalla + ".");
        }
    }
}
