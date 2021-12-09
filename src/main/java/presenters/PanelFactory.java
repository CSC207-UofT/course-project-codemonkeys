package presenters;

import usecase.DataAccessInterfaceRelay;

import javax.swing.*;
import java.util.Objects;

public class PanelFactory {
    /**
     * Factory design pattern for creating JPanels to be used to display on the JFrame based GUI.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */

    //____________________ Variables ___________________________________________________________________________________
    DataAccessInterfaceRelay api;


    //____________________ Constructors ________________________________________________________________________________
    public PanelFactory(DataAccessInterfaceRelay api) {
        this.api = api;
    }


    // Makes JPanels to display on the GUI
    public JPanel makePanel(String type, int x, int y, int width, int height) {

        if (Objects.equals(type, "Text")) {
            TextPanel text = new TextPanel(api);
            return text.getPanel(x, y, width, height);
        } else if (Objects.equals(type, "Portfolio Value Chart")) {
            PortfolioValueChartPanel growthChart = new PortfolioValueChartPanel(api);
            return growthChart.getPanel(x, y, width, height);
        } else if (Objects.equals(type, "Portfolio Composition Chart")) {
            PortfolioPieChartPanel pieChart = new PortfolioPieChartPanel(api);
            return pieChart.getPanel(x, y, width, height);
        } else if (Objects.equals(type, "Asset Growth Chart")) {
            AssetGrowthChartPanel barChart = new AssetGrowthChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        } else if (Objects.equals(type, "Portfolio Growth Chart")) {
            PortfolioGrowthChartPanel barChart = new PortfolioGrowthChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        } else if (Objects.equals(type, "User Leaderboard")) {
            UserLeaderboardChartPanel barChart = new UserLeaderboardChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        }
        return null;
    }
}
