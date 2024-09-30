package es.cheste.DI.Calculadora;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JTextField txtCelsius;
    JButton[] botones = new JButton[16];
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();


    public Ventana() {
        setTitle("Calculadora");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));

        panel1.setLayout(new GridLayout(1,1,5,5));
        panel2.setLayout(new GridLayout(2,2,5,5));
        panel3.setLayout(new GridLayout(2,2,5,5));


        txtCelsius = new JTextField(15);
        txtCelsius.setEditable(false);
        txtCelsius.setBorder(BorderFactory.createLineBorder(Color.BLUE));


        botones[0] = new JButton("1");
        botones[1] = new JButton("2");
        botones[2] = new JButton("3");
        botones[3] = new JButton("+");
        botones[3].setBackground(Color.getHSBColor(128f,206f,225f));
        botones[4] = new JButton("4");
        botones[5] = new JButton("5");
        botones[6] = new JButton("6");
        botones[7] = new JButton("-");
        botones[7].setBackground(Color.getHSBColor(128f,206f,225f));
        botones[8] = new JButton("7");
        botones[9] = new JButton("8");
        botones[10] = new JButton("9");
        botones[11] = new JButton("*");
        botones[11].setBackground(Color.getHSBColor(128f,206f,225f));
        botones[12] = new JButton("0");
        botones[13] = new JButton(".");
        botones[13].setBackground(Color.getHSBColor(128f,206f,225f));
        botones[14] = new JButton("=");
        botones[14].setBackground(Color.getHSBColor(128f,206f,225f));
        botones[15] = new JButton("/");
        botones[15].setBackground(Color.getHSBColor(128f,206f,225f));


        panel1.add(txtCelsius);
        add(panel1);

        panel2.add(botones[0]);
        panel2.add(botones[1]);
        panel2.add(botones[2]);
        panel2.add(botones[3]);
        panel2.add(botones[4]);
        panel2.add(botones[5]);
        panel2.add(botones[6]);
        panel2.add(botones[7]);
        add(panel2);

        panel3.add(botones[8]);
        panel3.add(botones[9]);
        panel3.add(botones[10]);
        panel3.add(botones[11]);
        panel3.add(botones[12]);
        panel3.add(botones[13]);
        panel3.add(botones[14]);
        panel3.add(botones[15]);
        add(panel3);

    }
}
