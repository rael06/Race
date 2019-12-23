package edu.perso.race.views;

import edu.perso.race.model.Car;

import javax.swing.*;
import java.awt.*;

public class UICar extends JLabel {
    private Car car;
    public UICar(Car car) {
        super(car.toString());
        this.car = car;
        setPreferredSize(new Dimension(570,50));
        setOpaque(true);
        setBackground(UIConstants.getColors().get(car.getId()));
        setHorizontalAlignment(CENTER);
    }

    public Car getCar() {
        return car;
    }
}
