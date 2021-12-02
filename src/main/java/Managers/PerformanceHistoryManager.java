package Managers;

import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import Containers.PerformanceHistories.AssetPerformanceHistory;
import Containers.PerformanceHistories.PortfolioPerformanceHistory;
import Containers.Portfolio;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class PerformanceHistoryManager {

    /**
     * Contains variables and methods used to evaluate the performance of the communal portfolio.
     */

    public static void updateTotalDeposite(double depositeVolume) {
        PortfolioPerformanceHistory pph = PortfolioPerformanceHistory.getInstance();
        pph.setTotalDeposit(pph.getTotalDeposit() + depositeVolume);
    }

    public static void recordHistory(Portfolio portfolio, DataAccessInterface api) {

        // Record both Asset and Portfolio performance histories.

        double portfolioValue = portfolio.getValue(api);
        List<Asset> assetList = portfolio.getAssetList();
        // Store a hashmap of all non-liquid assets
        HashMap<String, Double> priceHistory = new HashMap<String, Double>();

        for (Asset a : assetList) {
            if (! (a instanceof Currency)) {
                priceHistory.put(a.getSymbol(), a.getValue());
            }
        }

        PortfolioPerformanceHistory.getInstance().recordHistory(portfolioValue);
        AssetPerformanceHistory.getInstance().recordHistory(priceHistory);

    }

    public static TreeMap<Date, Object> getAssetHistory() {
        return AssetPerformanceHistory.getInstance().getHistory();
    }

    public static TreeMap<Date, Object> getPortfolioHistory() {
        return PortfolioPerformanceHistory.getInstance().getHistory();
    }







}
