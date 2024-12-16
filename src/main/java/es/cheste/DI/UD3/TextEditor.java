package es.cheste.DI.UD3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextEditor() {
        // Configuración principal de la ventana
        setTitle("Editor de Texto");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el área de texto
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem nuevoItem = new JMenuItem("Nuevo");
        JMenuItem abrirItem = new JMenuItem("Abrir");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem salirItem = new JMenuItem("Salir");

        menuArchivo.add(nuevoItem);
        menuArchivo.add(abrirItem);
        menuArchivo.add(guardarItem);
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);

        menuBar.add(menuArchivo);

        // Menú Edición
        JMenu menuEdicion = new JMenu("Edición");

        // Submenú Tamaño de Fuente
        JMenu submenuTamanoFuente = new JMenu("Tamaño de Fuente");
        JMenuItem tamano12 = new JMenuItem("12");
        JMenuItem tamano18 = new JMenuItem("18");
        JMenuItem tamano26 = new JMenuItem("26");

        submenuTamanoFuente.add(tamano12);
        submenuTamanoFuente.add(tamano18);
        submenuTamanoFuente.add(tamano26);

        // Submenú Tipo de Fuente
        JMenu submenuTipoFuente = new JMenu("Tipo de Fuente");
        JMenuItem fuenteCourier = new JMenuItem("Courier");
        JMenuItem fuenteArial = new JMenuItem("Arial");
        JMenuItem fuenteTimes = new JMenuItem("Times New Roman");

        submenuTipoFuente.add(fuenteCourier);
        submenuTipoFuente.add(fuenteArial);
        submenuTipoFuente.add(fuenteTimes);

        menuEdicion.add(submenuTamanoFuente);
        menuEdicion.add(submenuTipoFuente);

        menuBar.add(menuEdicion);

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem acercaDeItem = new JMenuItem("Acerca de");
        menuAyuda.add(acercaDeItem);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        // Barra de herramientas
        JToolBar toolBar = new JToolBar();
        JButton nuevoBtn = new JButton("Nuevo");
        JButton abrirBtn = new JButton("Abrir");
        JButton guardarBtn = new JButton("Guardar");

        toolBar.add(nuevoBtn);
        toolBar.add(abrirBtn);
        toolBar.add(guardarBtn);

        add(toolBar, BorderLayout.NORTH);

        // Margenes de la hoja de texto
        JPanel margenIzquierdo = new JPanel();
        JPanel margenDerecho = new JPanel();
        JPanel margenInferior = new JPanel();

        margenIzquierdo.setPreferredSize(new Dimension(50, 0));
        margenDerecho.setPreferredSize(new Dimension(50, 0));
        margenInferior.setPreferredSize(new Dimension(0, 50));

        add(margenInferior, BorderLayout.SOUTH);
        add(margenIzquierdo, BorderLayout.WEST);
        add(margenDerecho, BorderLayout.EAST);

        // Configuración del selector de archivos
        fileChooser = new JFileChooser();

        // Acciones para los menús y botones
        nuevoItem.addActionListener(e -> nuevoArchivo());
        abrirItem.addActionListener(e -> abrirArchivo());
        guardarItem.addActionListener(e -> guardarArchivo());
        salirItem.addActionListener(e -> System.exit(0));
        acercaDeItem.addActionListener(e -> mostrarAcercaDe());

        nuevoBtn.addActionListener(e -> nuevoArchivo());
        abrirBtn.addActionListener(e -> abrirArchivo());
        guardarBtn.addActionListener(e -> guardarArchivo());

        // Acciones para el menú Edición
        tamano12.addActionListener(e -> cambiarTamanoFuente(12));
        tamano18.addActionListener(e -> cambiarTamanoFuente(18));
        tamano26.addActionListener(e -> cambiarTamanoFuente(26));

        fuenteCourier.addActionListener(e -> cambiarTipoFuente("Courier"));
        fuenteArial.addActionListener(e -> cambiarTipoFuente("Arial"));
        fuenteTimes.addActionListener(e -> cambiarTipoFuente("Times New Roman"));
    }

    private void nuevoArchivo() {
        textArea.setText("");
    }

    private void abrirArchivo() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarArchivo() {
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this, "Editor de Texto\nCreado por Sergio Rosa", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cambiarTamanoFuente(int tamano) {
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), tamano));
    }

    private void cambiarTipoFuente(String tipo) {
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(tipo, currentFont.getStyle(), currentFont.getSize()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}
