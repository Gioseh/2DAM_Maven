package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaJFileChooser extends JFrame {

    public VentanaJFileChooser() {
        setTitle("Ejemplo de JFileChooser");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botón para abrir el JFileChooser
        JButton button = new JButton("Seleccionar Archivo");

        // Etiqueta para mostrar la ruta del archivo seleccionado
        JLabel label = new JLabel("No se ha seleccionado ningún archivo.");

        // Añadir el botón y la etiqueta al marco
        add(button);
        add(label);

        // Agregar un ActionListener al botón para mostrar el JFileChooser
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un JFileChooser
                JFileChooser fileChooser = new JFileChooser();

                // Mostrar el diálogo de selección de archivo (Abrir archivo)
                int result = fileChooser.showOpenDialog(null);

                // Procesar el resultado de la selección
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Obtener el archivo seleccionado
                    File selectedFile = fileChooser.getSelectedFile();

                    // Mostrar la ruta del archivo en la etiqueta
                    label.setText("Archivo seleccionado: " + selectedFile.getAbsolutePath());
                } else {
                    label.setText("La selección fue cancelada.");
                }
            }
        });

        setVisible(true);
    }
}
