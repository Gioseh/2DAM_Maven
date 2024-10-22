package es.cheste.DI.UD3.Menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Componentes extends JFrame {
    private JMenuBar jmbarBarraDeMenus;
    private JMenu jmnuArchivo;
    private JMenuItem jmItemAbrir;
    private JMenu jmnuGuardar;
    private JSeparator jSeparador1;
    private JMenuItem jmItemGuardar;
    private JMenuItem jmItemOtroNombre;
    private JMenuItem jmItemSalir;

    private JButton jbtbarAbrir;
    private JButton jbtbarGuardar;

    private JToolBar jtbarBarraDeHerr;

    private JPanel jBarraDeEstado;
    private JLabel jetbarestPpal;

    public Componentes(){
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        this.setSize(400,250);
        setResizable(true);



        jmbarBarraDeMenus = new JMenuBar();
        jmItemAbrir = new JMenuItem();
        jmnuArchivo = new JMenu();
        jmnuGuardar = new JMenu();
        jSeparador1 = new JSeparator();
        jmItemGuardar = new JMenuItem();
        jmItemOtroNombre = new JMenuItem();
        jmItemSalir = new JMenuItem();
        jtbarBarraDeHerr = new JToolBar();

        jmnuArchivo.setMnemonic('A');
        jmnuArchivo.setText("Archivo");

        jmItemAbrir.setMnemonic('A');
        jmItemAbrir.setText("Abrir...");
        jmnuArchivo.add(jmItemAbrir);

        jmItemGuardar.setMnemonic('G');
        jmItemGuardar.setText("Guardar");
        jmnuArchivo.add(jmItemGuardar);

        jmItemSalir.setMnemonic('S');
        jmItemSalir.setText("Salir");
        jmnuArchivo.add(jmItemSalir);

        jmnuGuardar.add(jSeparador1);


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
                }
                if(item == jmItemGuardar){
                    jmItemGuardarActionPerformed(evt);
                }
                if (item == jmItemOtroNombre){
                    //jmItemOtroNombreActionPerformed(evt);
                }
                if (item == jmItemSalir){
                    jmItemSalirActionPerformed(evt);
                }
            }
        };

        //-------------------- AÑADIMOS LOS ACTIONLISTERS A LOS ITEMS ----------

        jmItemAbrir.addActionListener(al);
        jmItemGuardar.addActionListener(al);
        jmItemSalir.addActionListener(al);

        jmItemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));

        jBarraDeEstado = new JPanel();
        jetbarestPpal = new JLabel();

        //-------------------- BARRA DE BOTONES -------------------------------

        setJMenuBar(jmbarBarraDeMenus);
        jbtbarAbrir = new JButton(new ImageIcon("src/main/resources/DI/UD3/Menus/abrir.png"));
        jbtbarAbrir.setToolTipText("Abrir");
        jbtbarAbrir.setFocusable(false);
        jbtbarAbrir.setMargin(new Insets(0,0,0,0));

        jbtbarGuardar = new JButton(new ImageIcon("src/main/resources/DI/UD3/Menus/guardar.png"));
        jbtbarGuardar.setToolTipText("Guardar");
        jbtbarGuardar.setFocusable(false);
        jbtbarGuardar.setMargin(new Insets(0,0,0,0));

        jtbarBarraDeHerr.add(jbtbarAbrir);
        jtbarBarraDeHerr.add(jbtbarGuardar);
        getContentPane().add(jtbarBarraDeHerr);
        jtbarBarraDeHerr.setBounds(0, 0, getWidth(), 32);

        //-------------------- BARRA DE ESTADO -------------------------------

        jBarraDeEstado.setBorder(BorderFactory.createEtchedBorder());
        jBarraDeEstado.setPreferredSize(new Dimension(492, 24));
        jBarraDeEstado.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));

        jetbarestPpal.setText("Listo");
        jetbarestPpal.setPreferredSize(new Dimension(492, 20));
        jBarraDeEstado.add(jetbarestPpal);

        jBarraDeEstado.setBounds(0, getHeight(), getWidth(), 24);
        getContentPane().add(jBarraDeEstado);






    }

    private void jmItemSalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jmItemGuardarActionPerformed(ActionEvent evt) {
        VentanaFileChooser ventanaFileChooser = new VentanaFileChooser();
    }

    private void jmItemAbrirActionPerformed(ActionEvent evt) {
        VentanaFileChooser ventanaFileChooser = new VentanaFileChooser();
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }
}
