package es.cheste.DI.JtextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// escuchador del botón.
class ButtonListener implements ActionListener {
    private JTextField textField1;

    public ButtonListener(JTextField textField1 ) {
        this.textField1 = textField1;
    }

    public void actionPerformed(ActionEvent e) {
// limpia los textfields.
        textField1.setText("");
        textField1.requestFocus(); // Da el foco al textfield1
    }
}
