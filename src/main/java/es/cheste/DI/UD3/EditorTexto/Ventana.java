package es.cheste.DI.UD3.EditorTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    JTextArea textArea;

    JMenuBar menuBar;
    JMenu menuArchivo;
    JMenuItem nuevo;
    JMenuItem abrir;
    JMenuItem guardar;

    JToolBar barraBotones;
    JButton botonSubrayar;
    JButton botonCursiva;
    JButton botonNegrita;


    public Ventana() {
        setTitle("Editor de texto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        BorderLayout borderLayout1 = new BorderLayout();
        setLayout(borderLayout1);


        //Menu
        menuBar = new JMenuBar();

        menuArchivo = new JMenu("Archivo");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");

        menuArchivo.add(nuevo);
        menuArchivo.add(abrir);
        menuArchivo.add(guardar);

        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        //BarraImagenes
        barraBotones = new JToolBar();

        botonSubrayar = new JButton(new ImageIcon("src/main/java/es/cheste/DI/UD3/Menus/Imagenes/subrayar.png"));
        botonCursiva = new JButton(new ImageIcon("src/main/java/es/cheste/DI/UD3/Menus/Imagenes/cursiva.png"));
        botonNegrita = new JButton(new ImageIcon("src/main/java/es/cheste/DI/UD3/Menus/Imagenes/bold.png"));

        // Agregar botones a la segunda barra de herramientas
        barraBotones.add(botonSubrayar);
        barraBotones.add(botonCursiva);
        barraBotones.add(botonNegrita);

        //TextArea
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        //Espacios

        JPanel margenIzquierdo = new JPanel();
        JPanel margenDerecho = new JPanel();
        JPanel margenInferior = new JPanel();

        margenIzquierdo.setPreferredSize(new Dimension(50, 0));
        margenDerecho.setPreferredSize(new Dimension(50, 0));
        margenInferior.setPreferredSize(new Dimension(0, 50));

        //Listeners
        nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abriendo archivo");
                VentanaFileChooser fc = new VentanaFileChooser();
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Guardando archivo");
                VentanaFileChooser fc = new VentanaFileChooser();
            }
        });



        //Añadir al panel
        add(barraBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(margenInferior, BorderLayout.SOUTH);
        add(margenIzquierdo, BorderLayout.WEST);
        add(margenDerecho, BorderLayout.EAST);
    }
}
