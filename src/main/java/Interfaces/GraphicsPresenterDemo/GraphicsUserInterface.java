package Interfaces.GraphicsPresenterDemo;

import javax.swing.*;

public class GraphicsUserInterface {
    public static void presentGraphics(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.add(ChartPanelFactory.makeChartPanel("Portfolio Value Chart", 0, 0, 500, 500));
        frame.add(ChartPanelFactory.makeChartPanel("Portfolio Composition Chart", 500, 0, 500, 500));
        frame.add(ChartPanelFactory.makeChartPanel("Asset Growth Chart", 0, 500, 500, 250));
        frame.add(ChartPanelFactory.makeChartPanel("Portfolio Growth Chart", 0, 750, 500, 250));
        frame.add(ChartPanelFactory.makeChartPanel("User Leaderboard", 500, 500, 500, 500));
    }
}