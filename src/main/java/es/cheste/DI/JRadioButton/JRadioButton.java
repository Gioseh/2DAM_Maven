package es.cheste.DI.JRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class JRadioButton extends JFrame
{
    private JTextField campoTexto; // se utiliza para mostrar los cambios en el tipo de letra
    private Font tipoLetraSimple; // tipo de letra para texto simple
    private Font tipoLetraNegrita; // tipo de letra para texto en negrita
    private Font tipoLetraCursiva; // tipo de letra para texto en cursiva
    private Font tipoLetraNegritaCursiva; // tipo de letra para texto en negrita y cursiva
    private javax.swing.JRadioButton simpleJRadioButton; // selecciona texto simple
    private javax.swing.JRadioButton negritaJRadioButton; // selecciona texto en negrita
    private javax.swing.JRadioButton cursivaJRadioButton; // selecciona texto en cursiva
    private javax.swing.JRadioButton negritaCursivaJRadioButton; // negrita y cursiva
    private ButtonGroup grupoOpciones; // grupo de botones que contiene los botones de opción
    public JRadioButton()
    {
        setTitle( "Prueba de RadioButton" );
        setSize(500,250);
        setLayout( new FlowLayout() ); // establece el esquema del marco
        campoTexto = new JTextField( "Observe el cambio en el estilo del tipo de letra", 40);
        add( campoTexto ); // agrega campoTexto a JFrame
// crea los botones de opción
        simpleJRadioButton = new javax.swing.JRadioButton( "Simple", true );
        negritaJRadioButton = new javax.swing.JRadioButton( "Negrita", false );
        cursivaJRadioButton = new javax.swing.JRadioButton( "Cursiva", false );
        negritaCursivaJRadioButton = new javax.swing.JRadioButton( "Negrita/Cursiva", false );
        add( simpleJRadioButton ); // agrega botón simple a JFrame
        add( negritaJRadioButton ); // agrega botón negrita a JFrame
        add( cursivaJRadioButton ); // agrega botón cursiva a JFrame
        add( negritaCursivaJRadioButton ); // agrega botón negrita y cursiva
// crea una relación lógica entre los objetos JRadioButton.JRadioButton
        grupoOpciones = new ButtonGroup(); // crea ButtonGroup
        grupoOpciones.add( simpleJRadioButton ); // agrega simple al grupo
        grupoOpciones.add( negritaJRadioButton ); // agrega negrita al grupo
        grupoOpciones.add( cursivaJRadioButton ); // agrega cursiva al grupo
        grupoOpciones.add( negritaCursivaJRadioButton ); // agrega negrita y cursiva
// crea objetos tipo de letra
        tipoLetraSimple = new Font( "Serif", Font.PLAIN, 14 );
        tipoLetraNegrita = new Font( "Serif", Font.BOLD, 14 );
        tipoLetraCursiva = new Font( "Serif", Font.ITALIC, 14 );
        tipoLetraNegritaCursiva = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
        campoTexto.setFont( tipoLetraSimple ); // establece tipo letra inicial a simple
// registra eventos para los objetos JRadioButton.JRadioButton
        simpleJRadioButton.addItemListener(
                new ManejadorBotonOpcion( tipoLetraSimple ) );
        negritaJRadioButton.addItemListener(
                new ManejadorBotonOpcion( tipoLetraNegrita ) );
        cursivaJRadioButton.addItemListener(
                new ManejadorBotonOpcion( tipoLetraCursiva ) );
        negritaCursivaJRadioButton.addItemListener(
                new ManejadorBotonOpcion( tipoLetraNegritaCursiva ) );
    } // fin del constructor de MarcoBotonOpcion
    // clase para eventos de botones de opción
    private class ManejadorBotonOpcion implements ItemListener
    {
        private Font tipoLetra; // tipo de letra asociado con este componente de escucha
        public ManejadorBotonOpcion( Font f )
        {
            tipoLetra = f; // establece el tipo de letra de este componente de escucha
        } // fin del constructor ManejadorBotonOpcion
        // maneja los eventos de botones de opción
        public void itemStateChanged( ItemEvent evento )
        {
            campoTexto.setFont( tipoLetra ); // establece el tipo de letra de campoTexto
        }
    }
}
