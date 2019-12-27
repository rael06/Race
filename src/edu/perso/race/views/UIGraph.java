package edu.perso.race.views;

import javax.swing.*;
import java.awt.*;

import static edu.perso.race.views.UIConstants.*;

public class UIGraph extends JPanel {
    private UICar[] uiCars;
    private Color color;

    public UIGraph(UICar[] uiCars) {
        super();
        this.uiCars = uiCars;
        init();
    }

    @Override
    public void paint(Graphics g) {
        int xGraphPositionStart = 50;
        int xGraphPositionEnd = MAIN_FRAME_WIDTH - 50;
        int graphWidth = xGraphPositionEnd - xGraphPositionStart;
        int yGraphPosition = getHeight() / 2;

        //horizontal scale
        g.drawLine(xGraphPositionStart, yGraphPosition, xGraphPositionEnd, yGraphPosition);

        //leftBorder
        g.drawLine(xGraphPositionStart, yGraphPosition - GRAPH_BORDERS_WIDTH, xGraphPositionStart, yGraphPosition + GRAPH_BORDERS_WIDTH);

        //bottom
        g.drawLine(xGraphPositionEnd, yGraphPosition - GRAPH_BORDERS_WIDTH, xGraphPositionEnd, yGraphPosition + GRAPH_BORDERS_WIDTH);

        //graduation
        double nbSection = graphWidth / GRAPH_SECTION_GAP;
        for (int i = 1; i <= nbSection; i++)
            g.drawLine(i * GRAPH_SECTION_GAP, yGraphPosition - GRAPH_MARKERS_WIDTH, i * GRAPH_SECTION_GAP, yGraphPosition + GRAPH_MARKERS_WIDTH);


        //marqueur result
//        if (max - min != 0) {
//            g.setColor(Color.red);
//            g.drawLine(3, (max-result) * 200/(max-min), 17, (max-result) * 200/(max-min));
//            System.out.println((max-result) * 200/(max-min));
//        }
    }

    private void init() {
        setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, GRAPH_HEIGHT));
    }
}
