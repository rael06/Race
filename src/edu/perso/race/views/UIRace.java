package edu.perso.race.views;

import edu.perso.race.model.Car;
import edu.perso.race.model.Race;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class UIRace extends JFrame {
    Race race = Race.getInstance();
    JPanel uiCarsPanel = new JPanel();
    UICar[] uiCars;

    public UIRace() {
        super("Race");
        init();
        initCars();
        showRace();
    }

    public void init() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        setLayout(fl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);
        add(uiCarsPanel);
    }

    public void initCars() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        uiCarsPanel.setLayout(fl);
        uiCarsPanel.setVisible(true);
        uiCarsPanel.setPreferredSize(new Dimension(600, 400));
        uiCars = new UICar[race.getCars().length];
        for (int i = 0; i < race.getCars().length; i++) {
            uiCars[i] = new UICar(race.getCars()[i]);
            uiCarsPanel.add(uiCars[i]);
        }
    }

    public void showRace() {
        race.start();
        while (Arrays.stream(race.getCars()).noneMatch(Car::isFinished)) {
            Arrays.sort(uiCars, new SortByUICarRestDistance());
            for(int i=0; i<uiCars.length; i++) {
                uiCarsPanel.setComponentZOrder(uiCars[i], i);
            }
            revalidate();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class SortByUICarRestDistance implements Comparator<UICar>
{
    @Override
    public int compare(UICar o1, UICar o2) {
        return o1.getCar().getRestDistance() - o2.getCar().getRestDistance();
    }
}
