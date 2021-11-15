package Interfaces.GraphicsPresenterDemo;

import org.jfree.chart.ChartPanel;

public class ChartPanelFactory {
    public static ChartPanel makeChartPanel(String type, int x, int y, int width, int height) {
        if (type == "Portfolio Value Chart") {
            PortfolioValueChartPanel growthChart = new PortfolioValueChartPanel();
            return growthChart.getChartPanel(x, y, width, height);
        } else if (type == "Portfolio Composition Chart") {
            PortfolioPieChartPanel pieChart = new PortfolioPieChartPanel();
            return pieChart.getChartPanel(x, y, width, height);
        } else if (type == "Asset Growth Chart") {
            AssetGrowthChartPanel barChart = new AssetGrowthChartPanel();
            return barChart.getChartPanel(x, y, width, height);
        } else if (type == "Portfolio Growth Chart") {
            PortfolioGrowthChartPanel barChart = new PortfolioGrowthChartPanel();
            return barChart.getChartPanel(x, y, width, height);
        } else if (type == "User Leaderboard") {
            UserLeaderboardChartPanel barChart = new UserLeaderboardChartPanel();
            return barChart.getChartPanel(x, y, width, height);
        }
        return null;
    }
}
