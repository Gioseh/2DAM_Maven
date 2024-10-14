package es.cheste.DI.JLabel;

import javax.swing.*;
import java.awt.*;

public class VentanaCheckBox extends JFrame{
    public VentanaCheckBox() {
        setTitle("Ventana Marco");
        setSize(400,300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JCheckBox op1 = new JCheckBox();
        op1.add(new Label("1"));
        op1.setSelected(true);

        JCheckBox op2 = new JCheckBox();
        op2.add(new Label("2"));

        JCheckBox op3 = new JCheckBox();
        op3.add(new Label("1"));
        panel.add(op1);
        panel.add(op2);
        panel.add(op3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
}
