package edu.perso.race.views;

import javax.swing.*;
import java.awt.*;

class UIFieldTitle extends JPanel {
    UIFieldTitle(String title) {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        add(new JLabel(title));
    }
}
