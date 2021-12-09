package usecase.managers;

import entities.assets.Asset;
import entities.assets.Currency;
import entities.assets.DataAccessInterface;
import entities.containers.PerformanceHistories.AssetPerformanceHistory;
import entities.containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class PerformanceHistoryManager {

    /**
     * Contains variables and methods used to evaluate the performance of the communal portfolio.
     */

    public static void updateTotalDeposit(double depositVolume) {
        CommunalPortfolioPerformanceHistory pph = CommunalPortfolioPerformanceHistory.getInstance();
        pph.setTotalDeposit(pph.getTotalDeposit() + depositVolume);
    }

    public static void recordHistory(DataAccessInterface api) {

        // Record both Asset and Portfolio performance histories.

        double portfolioValue = AssetManager.getInstance().getValue(api);
        List<Asset> assetList = AssetManager.getInstance().getAssetList();
        // Store a hashmap of all non-liquid assets
        HashMap<String, Double> priceHistory = new HashMap<>();

        for (Asset a : assetList) {
            if (! (a instanceof Currency)) {
                priceHistory.put(a.getSymbol(), a.getValue());
            }
        }

        CommunalPortfolioPerformanceHistory.getInstance().recordHistory(portfolioValue);
        AssetPerformanceHistory.getInstance().recordHistory(priceHistory);

    }

    public static TreeMap<Date, Object> getAssetHistory() {
        return AssetPerformanceHistory.getInstance().getHistory();
    }

    public static TreeMap<Date, Object> getPortfolioHistory() {
        return CommunalPortfolioPerformanceHistory.getInstance().getHistory();
    }







}
