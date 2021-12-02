package Containers.PerformanceHistories;

import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

//TODO: add tests and serialize

public class PortfolioPerformanceHistory {
    private final TreeMap<Date, Object> treeQueue = new TreeMap<>();
    private final int size;
    private static final PortfolioPerformanceHistory instance = new PortfolioPerformanceHistory();
    private double totalDeposit = 0;

    private PortfolioPerformanceHistory() {
        size = 168; // Hours in a week
    }

    public void recordHistory(Map<String, Double> history) {
        treeQueue.put(new Date(), history);

        if (treeQueue.size() > size) {
            treeQueue.remove(treeQueue.firstKey());
        }
    }

    public static PortfolioPerformanceHistory getInstance() { return instance; }

    public double getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }
}
