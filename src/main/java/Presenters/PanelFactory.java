package Presenters;

import Entities.Assets.DataAccessInterface;

import javax.swing.*;

public class PanelFactory {

    //____________________ Variables ___________________________________________________________________________________
    DataAccessInterface api;


    //____________________ Constructors ________________________________________________________________________________
    public PanelFactory(DataAccessInterface api){
        this.api = api;
    };


    // Makes JPanels to display on the GUI
    public JPanel makePanel(String type, int x, int y, int width, int height) {

        if (type == "Text") {
            TextPanel text = new TextPanel(api);
            return text.getPanel(x, y, width, height);
        } else if (type == "Portfolio Value Chart") {
            PortfolioValueChartPanel growthChart = new PortfolioValueChartPanel();
            return growthChart.getPanel(x, y, width, height);
        } else if (type == "Portfolio Composition Chart") {
            PortfolioPieChartPanel pieChart = new PortfolioPieChartPanel(api);
            return pieChart.getPanel(x, y, width, height);
        } else if (type == "Asset Growth Chart") {
            AssetGrowthChartPanel barChart = new AssetGrowthChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        } else if (type == "Portfolio Growth Chart") {
            PortfolioGrowthChartPanel barChart = new PortfolioGrowthChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        } else if (type == "User Leaderboard") {
            UserLeaderboardChartPanel barChart = new UserLeaderboardChartPanel(api);
            return barChart.getPanel(x, y, width, height);
        }
        return null;
    }
}
