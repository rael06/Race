package edu.perso.race.views;

import javax.swing.*;
import java.awt.*;

public class UIFieldPanel extends JPanel {
    private UIField field;

    UIFieldPanel(String title) {
        UIFieldTitle t = new UIFieldTitle(title);
        field = new UIField();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.MAIN_FRAME_WIDTH/4, 70));

        add(BorderLayout.NORTH, t);
        add(BorderLayout.CENTER, field);
    }

    UIField getField() {
        return field;
    }
}
