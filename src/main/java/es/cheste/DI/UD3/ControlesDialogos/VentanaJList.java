package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;

public class VentanaJList extends javax.swing.JFrame {


    public VentanaJList() {
        JScrollPane jScrollPane = crearJScrollPane(iniciarLista());
        this.add(jScrollPane);
        this.setSize(300,200);
        this.setVisible(true);
    }

    private JScrollPane crearJScrollPane(String[] elementos){
        JList<String> lista = new JList<>(elementos);
        JScrollPane jScrollPane = new JScrollPane(lista);
        return jScrollPane;
    }

    private String[] iniciarLista() {
         String[] elementos = { "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5","Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5","Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5" };
         return elementos;
    }
}
