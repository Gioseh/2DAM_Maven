package es.cheste.DI.UD2.FormatoTexto.FormatoTextoCheck;

import javax.swing.*;
import java.awt.*;

public class VentanaFormatoTextoCheck extends JFrame {

    private JRadioButton rbPlain, rbBold, rbItalic, rbBoldItalic;
    private JRadioButton rbT12, rbT14, rbT18, rbT32;
    private JRadioButton rbCourier, rbTimesNewRoman;
    private JLabel texto;

    public VentanaFormatoTextoCheck() {
        super("Selector de fuente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new GridLayout(4, 1));

        texto = new JLabel("Texto de ejemplo");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setFont(new Font("Courier", Font.PLAIN, 14)); // Valores por defecto
        add(texto, BorderLayout.CENTER);

        JPanel panelEstilo = new JPanel(new GridLayout(1, 4));
        JPanel panelTamano = new JPanel(new GridLayout(1, 4));
        JPanel panelTipografia = new JPanel(new GridLayout(1, 2));

        // ====== Estilo (Plain, Bold, Italic, Bold+Italic) ======
        rbPlain = new JRadioButton("Plain", true);
        rbBold = new JRadioButton("Bold");
        rbItalic = new JRadioButton("Italic");
        rbBoldItalic = new JRadioButton("Bold+Italic");

        ButtonGroup grupoEstilo = new ButtonGroup();
        grupoEstilo.add(rbPlain);
        grupoEstilo.add(rbBold);
        grupoEstilo.add(rbItalic);
        grupoEstilo.add(rbBoldItalic);

        panelEstilo.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panelEstilo.add(rbPlain);
        panelEstilo.add(rbBold);
        panelEstilo.add(rbItalic);
        panelEstilo.add(rbBoldItalic);

        // ====== Tamaño (12, 14, 18, 32) ======
        rbT12 = new JRadioButton("12");
        rbT14 = new JRadioButton("14", true);  // Valor por defecto
        rbT18 = new JRadioButton("18");
        rbT32 = new JRadioButton("32");

        ButtonGroup grupoTamano = new ButtonGroup();
        grupoTamano.add(rbT12);
        grupoTamano.add(rbT14);
        grupoTamano.add(rbT18);
        grupoTamano.add(rbT32);

        panelTamano.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panelTamano.add(rbT12);
        panelTamano.add(rbT14);
        panelTamano.add(rbT18);
        panelTamano.add(rbT32);

        // ====== Tipografía (Courier, Times New Roman) ======
        rbCourier = new JRadioButton("Courier", true);  // Valor por defecto
        rbTimesNewRoman = new JRadioButton("Times New Roman");

        ButtonGroup grupoTipografia = new ButtonGroup();
        grupoTipografia.add(rbCourier);
        grupoTipografia.add(rbTimesNewRoman);

        panelTipografia.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panelTipografia.add(rbCourier);
        panelTipografia.add(rbTimesNewRoman);

        panelPrincipal.add(panelEstilo);
        panelPrincipal.add(panelTamano);
        panelPrincipal.add(panelTipografia);

        add(panelPrincipal, BorderLayout.SOUTH);

        new LogicaVentanaCheck(this);
    }

    public JRadioButton getRbPlain() {
        return rbPlain;
    }

    public JRadioButton getRbBold() {
        return rbBold;
    }

    public JRadioButton getRbItalic() {
        return rbItalic;
    }

    public JRadioButton getRbBoldItalic() {
        return rbBoldItalic;
    }

    public JRadioButton getRbT12() {
        return rbT12;
    }

    public JRadioButton getRbT14() {
        return rbT14;
    }

    public JRadioButton getRbT18() {
        return rbT18;
    }

    public JRadioButton getRbT32() {
        return rbT32;
    }

    public JRadioButton getRbCourier() {
        return rbCourier;
    }

    public JRadioButton getRbTimesNewRoman() {
        return rbTimesNewRoman;
    }

    public JLabel getTexto() {
        return texto;
    }
}
