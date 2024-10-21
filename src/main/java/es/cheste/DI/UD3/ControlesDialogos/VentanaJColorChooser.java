package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJColorChooser extends JFrame {
    public VentanaJColorChooser() {
        // Configuración del marco (JFrame)
        setTitle("Ejemplo de JColorChooser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear un botón para abrir el JColorChooser
        JButton button = new JButton("Seleccionar Color");

        // Crear un panel cuyo color de fondo será modificado
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(200, 100));
        colorPanel.setBackground(Color.WHITE); // Color inicial

        // Añadir el botón y el panel al marco
        add(button);
        add(colorPanel);

        // Agregar un ActionListener al botón para abrir el JColorChooser
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir el diálogo JColorChooser para seleccionar un color
                Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", colorPanel.getBackground());
                // Si se selecciona un color, cambiar el color de fondo del panel
                if (selectedColor != null) {
                    colorPanel.setBackground(selectedColor);
                }
            }
        });

        setVisible(true);
    }
}
