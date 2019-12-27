package edu.perso.race.views;

import edu.perso.race.model.Car;
import edu.perso.race.model.Race;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static edu.perso.race.views.UIConstants.*;

public class UIGraph extends JPanel implements Runnable {
    private UICar[] uiCars;
    private int yGraphPosition;
    private int xGraphPositionStart;
    private int graphWidth;

    public UIGraph(UICar[] uiCars) {
        super();
        this.uiCars = uiCars;
        init();
    }

    @Override
    public void paint(Graphics g) {
        int xGraphPositionEnd = MAIN_FRAME_WIDTH - 50;
        xGraphPositionStart = 50;
        graphWidth = xGraphPositionEnd - xGraphPositionStart;
        yGraphPosition = getHeight() / 2;

        //horizontal scale
        g.drawLine(xGraphPositionStart, yGraphPosition, xGraphPositionEnd, yGraphPosition);

        //leftBorder
        g.drawLine(xGraphPositionStart, yGraphPosition - GRAPH_BORDERS_WIDTH, xGraphPositionStart, yGraphPosition + GRAPH_BORDERS_WIDTH);

        //bottom
        g.drawLine(xGraphPositionEnd, yGraphPosition - GRAPH_BORDERS_WIDTH, xGraphPositionEnd, yGraphPosition + GRAPH_BORDERS_WIDTH);

        //graduation
        double nbSection = graphWidth / GRAPH_SECTION_GAP;
        for (int i = 1; i <= nbSection; i++) {
            g.drawLine(i * GRAPH_SECTION_GAP, yGraphPosition - GRAPH_MARKERS_WIDTH, i * GRAPH_SECTION_GAP, yGraphPosition + GRAPH_MARKERS_WIDTH);
        }
    }

    private void init() {
        setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, GRAPH_HEIGHT));
    }

    @Override
    public void run() {
        while (Arrays.stream(Race.getInstance().getCars()).noneMatch(Car::isFinished)) {
            getParent().repaint(1000);
            Graphics g = getGraphics();
            int carPosX;
            int restDistance;
            for (UICar uiCar : uiCars) {
                restDistance = uiCar.getCar().getRestDistance();
                carPosX = Race.getInstance().getDistance() - restDistance;
                carPosX = (int) Math.floor(carPosX * graphWidth / Race.getInstance().getDistance()) + xGraphPositionStart;
                g.setColor(uiCar.getColor());
                g.fillRect(carPosX, yGraphPosition - 15, 2, 30);
            }
        }
    }
}
