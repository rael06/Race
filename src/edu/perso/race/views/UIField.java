package edu.perso.race.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

class UIField extends JPanel {
    private String text = "";
    UIField() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(true);
        JTextField tf = new JTextField(20);
        add(tf);

        tf.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                showText(tf);
            }
        });

    }

    private void showText(JTextField tf) {
        text = tf.getText();
    }

    String getText() {
        return text;
    }
}
