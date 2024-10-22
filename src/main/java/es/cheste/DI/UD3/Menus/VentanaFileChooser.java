package es.cheste.DI.UD3.Menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaFileChooser extends JFileChooser {
    private String fileName;

    public VentanaFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // Mostrar el diálogo de selección de archivo (Abrir archivo)
        int result = fileChooser.showOpenDialog(null);

        // Procesar el resultado de la selección
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();

            // Mostrar la ruta del archivo en la etiqueta
           fileName = "Archivo seleccionado: " + selectedFile.getAbsolutePath();
        }



        setVisible(true);
    }
}
