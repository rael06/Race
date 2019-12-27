package edu.perso.race.views;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UIConstants {
    public static final int MAIN_FRAME_WIDTH = 600;
    public static final int UI_CAR_FRAME_HEIGHT = 36;
    public static final int UI_CAR_LABEL_HEIGHT = 30;
    public static final int GRAPH_HEIGHT = 200;
    public static final int GRAPH_SECTION_GAP = 50;
    public static final int GRAPH_BORDERS_WIDTH = 5;
    public static final int GRAPH_MARKERS_WIDTH = 2;

    public static Map<Integer, Color> colors = new HashMap<>();

    public static Map<Integer, Color> getColors() {
        if (colors.isEmpty()) {
            colors.put(1, Color.RED);
            colors.put(2, Color.YELLOW);
            colors.put(3, Color.BLUE);
            colors.put(4, Color.CYAN);
            colors.put(5, Color.PINK);
            colors.put(6, Color.ORANGE);
            colors.put(7, Color.MAGENTA);
            colors.put(8, Color.DARK_GRAY);
            colors.put(9, Color.LIGHT_GRAY);
            colors.put(10, Color.BLACK);
        }
        return colors;
    }
}
