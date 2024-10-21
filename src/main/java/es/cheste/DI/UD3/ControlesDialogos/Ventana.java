package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private String contrasena;
    public Ventana() {
        setTitle("Ejemplo de JLablel");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

//cambio el layout por defecto del panel
        panel.setLayout(new GridLayout(5,3));


//creo tres etiquetas

        Button[] botones = new Button[15];
        botones[0] = new Button("showMessageDialog");
        botones[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Hello World","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });

        botones[1] = new Button("showConfirmDialog");
        botones[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int boton = javax.swing.JOptionPane.showConfirmDialog(null,"¿Desea continuar?");
            }
        });

        botones[2] = new Button("showInputDialog");
        botones[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                contrasena = javax.swing.JOptionPane.showInputDialog("Contraseña: ");
            }
        });

        botones[3] = new Button("showOptionDialog");
        botones[3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "Sí, gracias", "No, gracias", "Más..." };

                javax.swing.JOptionPane.showOptionDialog(null,
                        "¿Se ha solucionado el problema?",
                        "Soluciones",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);
            }
        });

        botones[4] = new Button("Jframe");
        botones[4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaMarco ventanaMarco = new VentanaMarco();
                ventanaMarco.setVisible(true);
            }
        });

        botones[5] = new Button("jTextFiekld");
        botones[5].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTextField ventanaTextField = new VentanaTextField();
            }
        });

        botones[6] = new Button("jCheckBox");
        botones[6].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCheckBox ventanaCheckBox = new VentanaCheckBox();
            }
        });

        botones[7] = new Button("jRadioButton");
        botones[7].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRadioButton ventanaRadioButton = new VentanaRadioButton();
            }
        });

        botones[8] = new Button("jList");
        botones[8].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJList ventanaJList = new VentanaJList();
            }
        });

        botones[9] = new Button("jScrollBar");
        botones[9].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJScrollBar ventanaJScrollBar = new VentanaJScrollBar();
            }
        });

        botones[10] = new Button("jSlider");
        botones[10].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJSlider ventanaJSlider = new VentanaJSlider();
            }
        });

        botones[11] = new Button("jProgressBar");
        botones[11].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJProgressBar ventanaJProgressBar = new VentanaJProgressBar();
            }
        });

        botones[12] = new Button("jFileChooser");
        botones[12].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJFileChooser ventanaJFileChooser = new VentanaJFileChooser();
            }
        });

        botones[13] = new Button("jColorChooser");
        botones[13].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJColorChooser ventanaJColorChooser = new VentanaJColorChooser();
            }
        });

        botones[14] = new Button("Timer");
        botones[14].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTimer ventanaTimer = new VentanaTimer();
            }
        });


        for (int i = 0; i < botones.length; i++) {
            panel.add(botones[i]);
        }


        add(panel);

    }
}
