package edu.perso.race.views;

import edu.perso.race.model.Car;

import javax.swing.*;
import java.awt.*;

import static edu.perso.race.views.UIConstants.MAIN_FRAME_WIDTH;
import static edu.perso.race.views.UIConstants.UI_CAR_LABEL_HEIGHT;

public class UICar extends JLabel {
    private Car car;
    private Color color;

    public UICar(Car car) {
        super(car.toString());
        this.car = car;
        color = UIConstants.getColors().get(car.getId());
        int xMargin = 30;
        setPreferredSize(new Dimension(MAIN_FRAME_WIDTH - xMargin, UI_CAR_LABEL_HEIGHT));
        setOpaque(true);
        setBackground(color);
        setForeground(UIUtils.optimizeContrast(color));
        setHorizontalAlignment(CENTER);
    }

    public Car getCar() {
        return car;
    }

    public Color getColor() {
        return color;
    }
}
