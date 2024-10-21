package es.cheste.DI.UD2.JCheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class MarcoCasillaVerificacion extends JFrame{
    private JTextField campoTexto;
    private JCheckBox negritaJCheckBox;
    private JCheckBox cursivaJCheckBox;

    public MarcoCasillaVerificacion(){
        setTitle( "Prueba de JCheckBox" );
        setLayout( new FlowLayout() );
        setSize(500,100);

        campoTexto = new JTextField( "Observe como cambia el estilo de tipo de letra", 25 );
        campoTexto.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
        add( campoTexto );
        negritaJCheckBox = new JCheckBox( "Negrita" );
        cursivaJCheckBox = new JCheckBox( "Cursiva" );
        add( negritaJCheckBox );
        add( cursivaJCheckBox );

        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negritaJCheckBox.addItemListener( manejador );
        cursivaJCheckBox.addItemListener( manejador );
    }


    private class ManejadorCheckBox implements ItemListener{
        private int valNegrita = Font.PLAIN;
        private int valCursiva = Font.PLAIN;

        public void itemStateChanged( ItemEvent evento ){

            if ( evento.getSource() == negritaJCheckBox )
                valNegrita = negritaJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

            if ( evento.getSource() == cursivaJCheckBox )
                valCursiva = cursivaJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;

            campoTexto.setFont( new Font( "Serif", valNegrita + valCursiva, 14 ) );
        }
    }
}
