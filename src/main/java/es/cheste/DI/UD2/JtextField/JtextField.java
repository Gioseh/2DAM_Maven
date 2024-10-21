package es.cheste.DI.UD2.JtextField;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;
import java.awt.*;

class JtextField extends JFrame {
    JTextField textField1;
     JTextField textField2;
    JPanel panel = new JPanel();

    public JtextField() {
        setTitle("Ejemplo de JTextField");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
// Crear dos textfield y un button
        textField1 = new JTextField("Teclea algo y presiona return", 20); // 20 columnas de ancho
        textField2 = new JTextField(20);

// Añadir un listener
        TextFieldListener tfl = new TextFieldListener(textField1, textField2);
        textField1.addActionListener(tfl);
        textField2.setText(tfl.pasarTexto());
// Asignar una línea negra de borde.
        textField1.setBorder(BorderFactory.createLineBorder(Color.black));

        textField2.setBorder(BorderFactory.createLineBorder(Color.blue));
        JButton button = new JButton("Limpiar");
        button.addActionListener(new ButtonListener(textField1));
// Añadir los elementos al panel
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button);
        add(panel);
    }


}