package edu.perso.race.views;

import java.awt.*;

public class UIUtils {
    public static Color optimizeContrast(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return red*0.299 + green*0.587 + blue*0.114 > 186 ? Color.BLACK : Color.WHITE;
    }
}
