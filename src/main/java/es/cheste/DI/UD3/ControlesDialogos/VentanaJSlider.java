package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VentanaJSlider extends JFrame {

    public VentanaJSlider() {
        setTitle("Ejemplo de JSlider");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear un JSlider con un rango de valores entre 0 y 100
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);  // Espaciado entre marcas grandes
        slider.setMinorTickSpacing(5);   // Espaciado entre marcas pequeñas
        slider.setPaintTicks(true);      // Mostrar las marcas
        slider.setPaintLabels(true);     // Mostrar los números de las marcas

        // Etiqueta que mostrará el valor actual del slider
        JLabel label = new JLabel("Valor: " + slider.getValue());

        // Escuchar cambios en el valor del slider
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Actualizar la etiqueta con el valor actual del slider
                label.setText("Valor: " + slider.getValue());
            }
        });

        // Añadir el slider y la etiqueta al marco
        add(slider);
        add(label);
        setVisible(true);
    }
}
