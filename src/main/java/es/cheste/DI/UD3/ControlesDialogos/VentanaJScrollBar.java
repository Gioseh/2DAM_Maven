package es.cheste.DI.UD3.ControlesDialogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class VentanaJScrollBar extends JFrame {
    public VentanaJScrollBar() {
        this.setLayout(new BorderLayout());
        crearScrollBar();
        this.setSize(300,200);

        this.setVisible(true);

    }

    private void crearScrollBar(){
        JScrollBar jScrollBar = new JScrollBar(JScrollBar.VERTICAL,0,20,0,120);

        JLabel label = new JLabel("Valor: 0", JLabel.CENTER);

        jScrollBar.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                label.setText("Valor: " + e.getValue());
            }
        });

        this.add(jScrollBar, BorderLayout.EAST);
        this.add(label, BorderLayout.CENTER);

    }
}
