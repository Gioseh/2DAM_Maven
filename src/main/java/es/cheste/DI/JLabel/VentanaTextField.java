package es.cheste.DI.JLabel;

import javax.swing.*;
import java.awt.*;

public class VentanaTextField extends JFrame{
    private JTextField textField;

    public VentanaTextField() {
        setTitle("Ventana Marco");
        setSize(400,300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField= new JTextField();
        textField.setEditable(Boolean.FALSE);
        textField.setText("\n");
        textField.setBorder(BorderFactory.createEmptyBorder());
        panel.add(textField, BorderLayout.SOUTH);

        textField= new JTextField();
        textField.setEditable(Boolean.FALSE);
        textField.setText("\n");
        textField.setBorder(BorderFactory.createEmptyBorder());
        panel.add(textField, BorderLayout.NORTH);

        textField= new JTextField();
        textField.setEditable(Boolean.FALSE);
        textField.setText("\t");
        textField.setBorder(BorderFactory.createEmptyBorder());
        panel.add(textField, BorderLayout.EAST);

        textField= new JTextField();
        textField.setEditable(Boolean.FALSE);
        textField.setText("\t");
        textField.setBorder(BorderFactory.createEmptyBorder());
        panel.add(textField, BorderLayout.WEST);

        panel.add(new JTextField(), BorderLayout.CENTER);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
