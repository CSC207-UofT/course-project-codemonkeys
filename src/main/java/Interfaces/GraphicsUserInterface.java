package Interfaces;

import javax.swing.*;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.Portfolio;
import Interfaces.GraphicsPresenter.*;

public class GraphicsUserInterface {
    public static void generateGraphics(Portfolio portfolio, DataAccessInterface api){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        PanelFactory pf = new PanelFactory(portfolio, api);

        frame.add(pf.makePanel("Text", 0, 0, 500, 250));
        frame.add(pf.makePanel("Portfolio Value Chart", 0, 500, 500, 500));
        frame.add(pf.makePanel("Portfolio Composition Chart", 500, 250, 500, 500));
        frame.add(pf.makePanel("Asset Growth Chart", 500, 750, 500, 250));
        frame.add(pf.makePanel("Portfolio Growth Chart", 0, 250, 500, 250));
        frame.add(pf.makePanel("User Leaderboard", 500, 0, 500, 250));
    }
}
