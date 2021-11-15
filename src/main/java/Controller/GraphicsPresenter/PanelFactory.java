package Controller.GraphicsPresenter;

import javax.swing.*;

public class PanelFactory {
    // Makes JPanels to display on the GUI
    public static JPanel makePanel(String type, int x, int y, int width, int height) {

        if (type == "Text") {
            TextPanel text = new TextPanel();
            return text.getPanel(x, y, width, height);
        } else if (type == "Portfolio Value Chart") {
            PortfolioValueChartPanel growthChart = new PortfolioValueChartPanel();
            return growthChart.getPanel(x, y, width, height);
        } else if (type == "Portfolio Composition Chart") {
            PortfolioPieChartPanel pieChart = new PortfolioPieChartPanel();
            return pieChart.getPanel(x, y, width, height);
        } else if (type == "Asset Growth Chart") {
            AssetGrowthChartPanel barChart = new AssetGrowthChartPanel();
            return barChart.getPanel(x, y, width, height);
        } else if (type == "Portfolio Growth Chart") {
            PortfolioGrowthChartPanel barChart = new PortfolioGrowthChartPanel();
            return barChart.getPanel(x, y, width, height);
        } else if (type == "User Leaderboard") {
            UserLeaderboardChartPanel barChart = new UserLeaderboardChartPanel();
            return barChart.getPanel(x, y, width, height);
        }
        return null;
    }
}
