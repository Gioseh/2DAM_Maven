package es.cheste.DI.Calculadora;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JTextField txtPantalla;
    JButton[] botones = new JButton[16];
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    public Ventana() {
        super();
    }

    public void iniciar() {
        setTitle("Calculadora");
        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 5, 5));

        // Configuración de los paneles
        panel1.setLayout(new GridLayout(1, 1, 5, 5));
        panel2.setLayout(new GridLayout(2, 4, 5, 5));
        panel3.setLayout(new GridLayout(2, 4, 5, 5));

        txtPantalla = new JTextField(15);
        txtPantalla.setEditable(false);
        txtPantalla.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // Crear botones y asignar lógica
        String[] labels = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "=", "/"};
        for (int i = 0; i < labels.length; i++) {
            botones[i] = new JButton(labels[i]);
        }

        int i = 0;

        for (JButton boton : botones) {
            if (i>=8){
                panel3.add(boton);
            }else{
                panel2.add(boton);
            }
            i++;
        }

        panel1.add(txtPantalla);
        add(panel1);
        add(panel2);
        add(panel3);

        setVisible(true);
    }
}
