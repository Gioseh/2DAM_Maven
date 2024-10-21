package es.cheste.DI.UD2.CalculadoraPro;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JTextField txtPantalla;
    JButton[] botones = new JButton[28];
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    public Ventana() {
        super();
    }

    public void iniciar() {
        setTitle("Calculadora");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 5, 5));

        // Configuración de los paneles
        panel1.setLayout(new GridLayout(1, 1, 5, 5));
        panel2.setLayout(new GridLayout(7, 4, 5, 5));


        txtPantalla = new JTextField(15);
        txtPantalla.setEditable(false);
        txtPantalla.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // Crear botones y asignar lógica
        String[] labels = {"MC","MR","M+","MS","%","Raíz","x2","M","CE","C","Ret","1/x","1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "=", "/"};
        for (int i = 0; i < labels.length; i++) {

            botones[i] = new JButton(labels[i]);

            switch (labels[i]){
                case "MC","MR","M+","MS","M":
                    botones[i].setBackground(Color.getHSBColor(0f,0.40f,0.90f));
                    break;
                case "1","2","3","4","5","6","7","8","9","0":
                    botones[i].setBackground(Color.getHSBColor(240f/360f,0.40f,0.90f));
                    break;
                case "CE","C":
                    botones[i].setBackground(Color.getHSBColor(180f/360f, 0.40f,0.90f));
                    break;
                case "+","-","*","/":
                    botones[i].setBackground(Color.getHSBColor(120f/360f, 0.40f,0.90f));
            }

        }


        for (JButton boton : botones) {

                panel2.add(boton);

        }

        panel1.add(txtPantalla);
        add(panel1);
        add(panel2);

        setVisible(true);
    }
}
