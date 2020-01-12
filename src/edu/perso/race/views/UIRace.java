package edu.perso.race.views;

import edu.perso.race.model.Race;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static edu.perso.race.views.UIConstants.*;

public class UIRace extends JFrame implements Runnable {
    private Race race = Race.getInstance();
    private JPanel uiCarsPanel = new JPanel();
    private JPanel graphPanel = new JPanel();
    private JPanel configPanel = new JPanel();
    private JButton startButton = new JButton("Start");
    private JButton readyButton = new JButton("Ready");
    private UIFieldPanel distanceField = new UIFieldPanel("Distance");
    private UIFieldPanel nbCarField = new UIFieldPanel("number of cars");
    private UIGraph uiGraph;
    private UICar[] uiCars;

    public UIRace() {
        super("Race");
        race.init(500, 3);
        init();
        initConfigPanel();
    }

    public void init() {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        setLayout(fl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, CONFIG_HEIGHT + 50 + 6));
        pack();
        setLocationRelativeTo(null);
        add(configPanel);
        add(graphPanel);
        add(uiCarsPanel);
    }

    public void initConfigPanel() {
        configPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        configPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, CONFIG_HEIGHT));
        configPanel.add(nbCarField);
        configPanel.add(distanceField);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, 40));
        readyButton.setPreferredSize(new Dimension(200, 30));
        readyButton.addActionListener(this::ready);
        startButton.setPreferredSize(new Dimension(200, 30));
        startButton.addActionListener(this::start);
        buttonsPanel.add(readyButton);
        buttonsPanel.add(startButton);
        configPanel.add(buttonsPanel);
    }

    public void initCars() {
        uiCarsPanel.removeAll();
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
        Thread t = new Thread(uiGraph);
        t.start();
        while (Arrays.stream(race.getCars()).anyMatch(c -> !c.isFinished())) {
            updateUICarsPanel();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            revalidate();
        }
    }

    public void updateUICarsPanel() {
        Arrays.sort(uiCars, new SortByUICarRestDistance());
        for (int i = 0; i < uiCars.length; i++) {
            uiCarsPanel.setComponentZOrder(uiCars[i], i);
        }
    }

    public void initGraphPanel() {
        graphPanel.removeAll();
        uiGraph = new UIGraph(uiCars);
        graphPanel.add(uiGraph);
        graphPanel.setBackground(Color.WHITE);
        graphPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, GRAPH_HEIGHT));
    }

    private void start(ActionEvent actionEvent) {
        Thread t = new Thread(this);
        t.start();
    }

    private void ready(ActionEvent actionEvent) {
        if (!distanceField.getField().getText().isEmpty() && !nbCarField.getField().getText().isEmpty()) {
            int distance = Integer.parseInt(distanceField.getField().getText());
            int nbCar = Integer.parseInt(nbCarField.getField().getText());
            race.init(distance, nbCar);
            setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, CONFIG_HEIGHT + GRAPH_HEIGHT + 50 + race.getCars().length * UI_CAR_FRAME_HEIGHT + 6));
            initCars();
            initGraphPanel();
            pack();
            setLocationRelativeTo(null);
            revalidate();
        }
    }

    @Override
    public void run() {
        showRace();
    }
}
