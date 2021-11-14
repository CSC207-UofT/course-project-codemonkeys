package Interfaces;

import javax.swing.*;
import Controller.GraphicsPresenter.*;

public class GraphicsUserInterface {
    public static void presentGraphics(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.add(PanelFactory.makePanel("Text", 0, 0, 500, 250));
        frame.add(PanelFactory.makePanel("Portfolio Value Chart", 0, 250, 500, 250));
        frame.add(PanelFactory.makePanel("Portfolio Composition Chart", 500, 0, 500, 500));
        frame.add(PanelFactory.makePanel("Asset Growth Chart", 0, 500, 500, 250));
        frame.add(PanelFactory.makePanel("Portfolio Growth Chart", 0, 750, 500, 250));
        frame.add(PanelFactory.makePanel("User Leaderboard", 500, 500, 500, 500));
    }
}
