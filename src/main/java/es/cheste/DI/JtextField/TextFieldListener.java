package es.cheste.DI.JtextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// escuchador del textfield
class TextFieldListener implements ActionListener {

    private JTextField textField1;
    private JTextField textField2;

    public TextFieldListener(JTextField textField1, JTextField textField2) {
        this.textField1 = textField1;
        this.textField2 = textField2;
    }

    public void actionPerformed(ActionEvent e) {
// coge el texto tecleado en textfield1
// y lo asigna al otro textfield.
        String text = textField1.getText();
        textField2.setText(text);

    }

    public String pasarTexto(){
        return textField1.getText();
    }
}
