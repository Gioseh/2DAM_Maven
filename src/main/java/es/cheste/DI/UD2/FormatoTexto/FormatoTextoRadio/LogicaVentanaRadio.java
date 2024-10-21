package es.cheste.DI.UD2.FormatoTexto.FormatoTextoRadio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogicaVentanaRadio {

    private VentanaFormatoTextoRadio ventana;

    public LogicaVentanaRadio(VentanaFormatoTextoRadio ventana) {
        this.ventana = ventana;
        agregarEventos();
    }

    private void agregarEventos() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarEstiloTexto();
            }
        };

        ventana.getRbPlain().addActionListener(listener);
        ventana.getRbBold().addActionListener(listener);
        ventana.getRbItalic().addActionListener(listener);
        ventana.getRbBoldItalic().addActionListener(listener);
        ventana.getRbT12().addActionListener(listener);
        ventana.getRbT14().addActionListener(listener);
        ventana.getRbT18().addActionListener(listener);
        ventana.getRbT32().addActionListener(listener);
        ventana.getRbCourier().addActionListener(listener);
        ventana.getRbTimesNewRoman().addActionListener(listener);
    }

    private void actualizarEstiloTexto() {
        int estilo = Font.PLAIN;
        int tamano = 14;  // Por defecto
        String tipografia = "Courier";  // Por defecto

        if (ventana.getRbBoldItalic().isSelected()) {
            estilo = Font.BOLD | Font.ITALIC;
        } else if (ventana.getRbBold().isSelected()) {
            estilo = Font.BOLD;
        } else if (ventana.getRbItalic().isSelected()) {
            estilo = Font.ITALIC;
        }

        if (ventana.getRbT12().isSelected()) {
            tamano = 12;
        } else if (ventana.getRbT14().isSelected()) {
            tamano = 14;
        } else if (ventana.getRbT18().isSelected()) {
            tamano = 18;
        } else if (ventana.getRbT32().isSelected()) {
            tamano = 32;
        }

        if (ventana.getRbTimesNewRoman().isSelected()) {
            tipografia = "Times New Roman";
        }

        ventana.getTexto().setFont(new Font(tipografia, estilo, tamano));
    }
}

