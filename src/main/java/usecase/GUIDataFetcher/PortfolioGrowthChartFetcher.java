package usecase.GUIDataFetcher;

import entities.assets.DataAccessInterface;
import entities.containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import usecase.managers.AssetManager;
import usecase.managers.PerformanceHistoryManager;

import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Date;
import java.util.TreeMap;

public class PortfolioGrowthChartFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */
    public static DefaultCategoryDataset getData(DataAccessInterface api) {
        String p = "Portfolio";

        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        TreeMap<Date, Object> history = PerformanceHistoryManager.getPortfolioHistory();

        int half = (int) Math.floor((float) history.size() / 2);

        double currentValue = AssetManager.getInstance().getValue(api);
        double totalInvestment = CommunalPortfolioPerformanceHistory.getInstance().getTotalDeposit();
        double fullTime = (Double) history.get(history.firstKey());
        double halfTime = (Double) history.values().toArray()[half];

        String fullTimeLabel = history.size() + " Hours";
        String halfTimeLabel = half + " Hours";
        String totalInvestmentLabel = "Total Investment";

        series.addValue( (currentValue - halfTime) / halfTime * 100, halfTimeLabel , p);
        series.addValue((currentValue - fullTime) / fullTime  * 100, fullTimeLabel, p);
        series.addValue( (currentValue - totalInvestment) / totalInvestment * 100, totalInvestmentLabel, p );

        return series;
    }

}
