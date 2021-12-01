package Containers.PerformanceHistories;

import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

//TODO: add tests

public class PortfolioPerformanceHistory {
    private final TreeMap<Date, Object> treeQueue = new TreeMap<>();
    private final int size;
    private static final PortfolioPerformanceHistory instance = new PortfolioPerformanceHistory();

    private PortfolioPerformanceHistory() {
        size = 168; // Hours in a week
    }

    public void recordHistory(Map<String, Double> history) {
        treeQueue.put(new Date(), history);

        if (treeQueue.size() > size) {
            treeQueue.remove(treeQueue.firstKey());
        }
    }

    public PortfolioPerformanceHistory getInstance() { return instance; }
}
