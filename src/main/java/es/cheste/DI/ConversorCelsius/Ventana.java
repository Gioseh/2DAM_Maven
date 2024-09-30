package es.cheste.DI.ConversorCelsius;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    JTextField txtCelsius, txtKelvin;
    JLabel lblCelsius, lblKelvin;
    JPanel panel = new JPanel();

    public Ventana() {
        setTitle("ConversorCelsius");
        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,2,5,5));

        lblCelsius = new JLabel("Grados Celsius");
        txtCelsius = new JTextField(10);

        lblKelvin = new JLabel("Grados Kelvin");
        lblKelvin.setHorizontalAlignment(SwingConstants.LEFT);
        txtKelvin = new JTextField(10);


        txtCelsius.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtKelvin.setText(String.valueOf(Double.parseDouble(txtCelsius.getText())+273.15));
            }
        });

        txtCelsius.setBorder(BorderFactory.createLineBorder(Color.RED));
        txtKelvin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCelsius.setText(String.valueOf(Double.parseDouble(txtKelvin.getText())-273.15));
            }
        });

        txtKelvin.setBorder(BorderFactory.createLineBorder(Color.RED));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCelsius.setText("");
                txtKelvin.setText("");
            }
        });

        btnLimpiar.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        panel.add(lblCelsius);
        panel.add(txtCelsius);
        panel.add(lblKelvin);
        panel.add(txtKelvin);
        panel.add(btnLimpiar);
        add(panel);

    }
}
