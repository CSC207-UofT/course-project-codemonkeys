package usecase.GUIDataFetcher;

import usecase.DataAccessInterfaceUsecaseRelay;
import usecase.managers.PerformanceHistoryManager;
import org.jfree.data.xy.XYSeries;

import java.util.Date;
import java.util.TreeMap;

public class PortfolioValueChartFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */
    public static XYSeries getData(DataAccessInterfaceUsecaseRelay api) {
        // Format the data as needed by JFreeChart

        var series = new XYSeries("Portfolio Value (US $)");

        PerformanceHistoryManager.recordHistory(api);
        TreeMap<Date, Object> history = PerformanceHistoryManager.getPortfolioHistory();

        Date timeNow = new Date();

        for (Date date : history.keySet()) {
            double diff = date.getTime() - timeNow.getTime();
            series.add(diff, (Double) history.get(date));
        }

        return series;
    }

}
