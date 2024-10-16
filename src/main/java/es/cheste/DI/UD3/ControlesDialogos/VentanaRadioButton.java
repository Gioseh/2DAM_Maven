package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;

public class VentanaRadioButton extends JFrame {
    public VentanaRadioButton() {
        setTitle("Ventana Marco");
        setSize(400,300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JRadioButton op1 = new JRadioButton("Opción 1");
        op1.setSelected(false);

        JRadioButton op2 = new JRadioButton("Opción 2");
        op2.setSelected(false);

        JRadioButton op3 = new JRadioButton("Opción 3");
        op3.setSelected(false);

        ButtonGroup group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);



        panel.add(op1);
        panel.add(op2);
        panel.add(op3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
    }
}
