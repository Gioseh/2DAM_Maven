package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTimer extends JFrame {
    private JLabel label;
    private int counter = 0;

    public VentanaTimer() {
        // Configuración del JFrame
        setTitle("Ejemplo de Swing Timer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Etiqueta que muestra el contador
        label = new JLabel("Contador: 0");
        add(label);

        // Crear un Timer que se ejecuta cada 1000ms (1 segundo)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                label.setText("Contador: " + counter);  // Actualizar la etiqueta
            }
        });

        // Iniciar el temporizador
        timer.start();
        setVisible(true);
    }
}
