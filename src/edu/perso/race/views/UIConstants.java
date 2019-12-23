package edu.perso.race.views;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UIConstants {
    private static Map<Integer, Color> colors = new HashMap<>();

    public static Map<Integer, Color> getColors() {
        if (colors.isEmpty()) {
            colors.put(1, Color.RED);
            colors.put(2, Color.YELLOW);
            colors.put(3, Color.BLUE);
            colors.put(4, Color.CYAN);
            colors.put(5, Color.PINK);
        }
        return colors;
    }
}
