package es.cheste.DI.FormatoTexto.FormatoTextoRadio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JRadio extends JFrame
{

    private JTextField campoTexto;
    private Font[] tipoLetra = new Font[4];
    private Font[] tamanos = new Font[4];
    private Font[] tipoLetras = new Font[2];
    private JRadioButton simpleJRadio;
    private JRadioButton negritaJRadio;
    private JRadioButton cursivaJRadio;
    private JRadioButton negritaCursivaJRadio;
    private JRadioButton[] buttonsTamanos = new JRadioButton[4];
    private JRadioButton[] buttonsTipografia = new JRadioButton[2];
    private ButtonGroup grupoOpciones;
    private ButtonGroup grupoOpTamano;
    private ButtonGroup grupoOpTipografia;

    public JRadio()
    {
        tipoLetra[0] = new Font( "Courier", Font.PLAIN, 14);
        tipoLetra[1] = new Font( "Courier", Font.BOLD, 14);
        tipoLetra[2] = new Font( "", Font.ITALIC, 14);
        tipoLetra[3] = new Font( "", Font.BOLD + Font.ITALIC, 14);

        buttonsTamanos[0] = new JRadioButton("12", false);
        buttonsTamanos[1] = new JRadioButton("14", true);
        buttonsTamanos[2] = new JRadioButton("18", false);
        buttonsTamanos[3] = new JRadioButton("32", false);

        buttonsTipografia[0] = new JRadioButton("Courier", true);
        buttonsTipografia[1] = new JRadioButton("Times New Roman", false);

        setTitle( "Prueba de RadioButton" );
        setSize(500,250);
        setLayout( new FlowLayout() );
        campoTexto = new JTextField( "Observe el cambio en el estilo del tipo de letra", 40);
        add( campoTexto );

        simpleJRadio = new JRadioButton( "Simple", true );
        negritaJRadio = new JRadioButton( "Negrita", false );
        cursivaJRadio = new JRadioButton( "Cursiva", false );
        negritaCursivaJRadio = new JRadioButton( "Negrita/Cursiva", false );

        add(simpleJRadio);
        add(negritaJRadio);
        add(cursivaJRadio);
        add(negritaCursivaJRadio);

        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(simpleJRadio);
        grupoOpciones.add(negritaJRadio);
        grupoOpciones.add(cursivaJRadio);
        grupoOpciones.add(negritaCursivaJRadio);

        grupoOpTamano = new ButtonGroup();
        grupoOpTamano.add(buttonsTamanos[0]);
        grupoOpTamano.add(buttonsTamanos[1]);
        grupoOpTamano.add(buttonsTamanos[2]);
        grupoOpTamano.add(buttonsTamanos[3]);

        grupoOpTipografia = new ButtonGroup();
        grupoOpTipografia.add(buttonsTipografia[0]);
        grupoOpTipografia.add(buttonsTipografia[1]);

        add(buttonsTamanos[0]);
        add(buttonsTamanos[1]);
        add(buttonsTamanos[2]);
        add(buttonsTamanos[3]);

        add(buttonsTipografia[0]);
        add(buttonsTipografia[1]);



        tamanos[0] = new Font("", Font.PLAIN, 12 );
        tamanos[1] = new Font("", Font.PLAIN, 14 );
        tamanos[2] = new Font("", Font.PLAIN, 18 );
        tamanos[3] = new Font("", Font.PLAIN, 32 );


        tipoLetras[0] = new Font( "Courier", Font.PLAIN, 0 );
        tipoLetras[1] = new Font( "Times New Roman", Font.PLAIN, 0 );




        campoTexto.setFont( tipoLetra[0] );

//        simpleJRadio.addItemListener(
//                new ManejadorBotonOpcion( tipoLetras[0],tipoLetraSimple, tamanos[1] ) );
//        negritaJRadio.addItemListener(
//                new ManejadorBotonOpcion( tipoLetras[0], tipoLetraNegrita, tamanos[1] ) );
//        cursivaJRadio.addItemListener(
//                new ManejadorBotonOpcion( tipoLetras[0] ,tipoLetraCursiva, tamanos[1] ) );
//        negritaCursivaJRadio.addItemListener(
//                new ManejadorBotonOpcion( tipoLetras[0], tipoLetraNegritaCursiva, tamanos[1] ) );


    }

    private class ManejadorBotonOpcion implements ItemListener
    {
        private Font tipoLetra;
        private Font tamano;
        private Font tipografia;
        public ManejadorBotonOpcion( Font f, Font f1, Font f2 )
        {
            tipoLetra = f;
            tamano = f1;
            tipografia = f2;
        }

        public void itemStateChanged( ItemEvent evento )
        {
            campoTexto.setFont( new Font(tipografia.getFontName(), tipoLetra.getStyle(), tamano.getSize()) );
        }
    }
}

