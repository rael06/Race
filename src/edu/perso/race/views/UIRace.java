package edu.perso.race.views;

import edu.perso.race.model.Car;
import edu.perso.race.model.Race;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

import static edu.perso.race.views.UIConstants.*;

public class UIRace extends JFrame {
    private Race race = Race.getInstance();
    private JPanel uiCarsPanel = new JPanel();
    private JPanel graphPanel = new JPanel();
    private UICar[] uiCars;

    public UIRace() {
        super("Race");
        init();
        initCars();
        initGraphPanel();
        showRace();
    }

    public void init() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        setLayout(fl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, GRAPH_HEIGHT + 50 + race.getCars().length * UI_CAR_FRAME_HEIGHT + 6));
        pack();
        setLocationRelativeTo(null);
        add(graphPanel);
        add(uiCarsPanel);
    }

    public void initCars() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        uiCarsPanel.setLayout(fl);
        uiCarsPanel.setVisible(true);
        uiCarsPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, race.getCars().length * UI_CAR_FRAME_HEIGHT));
        uiCars = new UICar[race.getCars().length];
        for (int i = 0; i < race.getCars().length; i++) {
            uiCars[i] = new UICar(race.getCars()[i]);
            uiCarsPanel.add(uiCars[i]);
        }
        uiCarsPanel.setBackground(Color.WHITE);
    }

    public void showRace() {
        race.start();
        while (Arrays.stream(race.getCars()).noneMatch(Car::isFinished)) {
            updateUICarsPanel();
            revalidate();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void updateUICarsPanel() {
        Arrays.sort(uiCars, new SortByUICarRestDistance());
        for (int i = 0; i < uiCars.length; i++) {
            uiCarsPanel.setComponentZOrder(uiCars[i], i);
        }
    }

    public void initGraphPanel() {
        UIGraph uiGraph = new UIGraph(uiCars);
        graphPanel.add(uiGraph);
        graphPanel.setBackground(Color.WHITE);
        graphPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, GRAPH_HEIGHT));
    }

    public void updateGraphPanel() {

    }
}
