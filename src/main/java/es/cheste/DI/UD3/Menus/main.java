package es.cheste.DI.UD3.Menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main extends JFrame {

    private JMenuBar jmbarBarraDeMenus;
    private JMenu jmnuArchivo;
    private JMenuItem jmItemAbrir;
    private JMenu jmnuGuardar;
    private JSeparator jSeparador1;
    private JMenuItem jmItemMismoNombre;
    private JMenuItem jmItemOtroNombre;
    private JMenuItem jmItemSalir;

    private JPanel jBarraDeEstado;
    private JLabel jetbarestPpal;

    public static void main(String[] args) {

    }

    public void initComponents() {

        jmbarBarraDeMenus = new JMenuBar();
        jmItemAbrir = new JMenuItem();
        jmnuArchivo = new JMenu();
        jmnuGuardar = new JMenu();
        jSeparador1 = new JSeparator();
        jmItemMismoNombre = new JMenuItem();
        jmItemOtroNombre = new JMenuItem();
        jmItemSalir = new JMenuItem();

        jmnuArchivo.setMnemonic('A');
        jmnuArchivo.setText("Archivo");

        jmItemAbrir.setMnemonic('A');
        jmItemAbrir.setText("Abrir...");

        jmnuGuardar.setMnemonic('G');
        jmnuGuardar.setText("Guardar");
        jmnuArchivo.add(jmnuGuardar);

        jmnuGuardar.add(jSeparador1);

        jmnuArchivo.add(jmItemAbrir);
        jmbarBarraDeMenus.add(jmnuArchivo);

        getContentPane().setLayout(null);
        addWindowListener (new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                exitForm(evt);
            }
        });

        ActionListener al = new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Object item = evt.getSource();
                if(item == jmItemAbrir){
                    jmItemAbrirActionPerformed(evt);
                }else if(item == jmItemMismoNombre){
                    jmItemMismoNombreActionPerformed(evt);
                }
                if (item == jmItemOtroNombre){
                    //jmItemOtroNombreActionPerformed(evt);
                }
                if (item == jmItemSalir){
                    //jmItemSalirActionPerformed(evt);
                }
            }
        };

        jmItemAbrir.addActionListener(al);
        jmItemMismoNombre.addActionListener(al);
        jmItemOtroNombre.addActionListener(al);
        jmItemSalir.addActionListener(al);

        jBarraDeEstado = new JPanel();
        jetbarestPpal = new JLabel();

        setJMenuBar(jmbarBarraDeMenus);

        jBarraDeEstado.setBorder(BorderFactory.createEtchedBorder());
        jBarraDeEstado.setPreferredSize(new Dimension(492, 24));
        jBarraDeEstado.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));

        jetbarestPpal.setText("Listo");
        jetbarestPpal.setPreferredSize(new Dimension(492, 20));
        jBarraDeEstado.add(jetbarestPpal);
        getContentPane().add(jBarraDeEstado);
        jBarraDeEstado.setBounds(0, 250, 500, 24);
    }

    private void jmItemMismoNombreActionPerformed(ActionEvent evt) {
    }

    private void jmItemAbrirActionPerformed(ActionEvent evt) {

    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }
}
