package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;

public class VentanaCheckBox extends JFrame{
    public VentanaCheckBox() {
        setTitle("Ventana Marco");
        setSize(400,300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JCheckBox op1 = new JCheckBox("Opción 1");
        op1.setSelected(false);

        JCheckBox op2 = new JCheckBox("Opcion 2");
        op2.setSelected(false);

        JCheckBox op3 = new JCheckBox("Opcion 3");
        op3.setSelected(false);

        panel.add(op1);
        panel.add(op2);
        panel.add(op3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
}
