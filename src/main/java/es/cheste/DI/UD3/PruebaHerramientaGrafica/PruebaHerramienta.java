package es.cheste.DI.UD3.PruebaHerramientaGrafica;

import javax.swing.*;

public class PruebaHerramienta {
    private JPanel panel1;
    private JTextField textField1;
    private JButton a4Button;
    private JButton a1Button1;
    private JButton a2Button;
    private JButton a3Button;
    private JButton mButton;
    private JButton button6;
    private JButton a8Button;
    private JButton a7Button;
    private JButton button9;
    private JButton button10;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a9Button;
    private JButton button14;
    private JButton a0Button;
    private JButton button16;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PruebaHerramienta");
        frame.setContentPane(new PruebaHerramienta().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
