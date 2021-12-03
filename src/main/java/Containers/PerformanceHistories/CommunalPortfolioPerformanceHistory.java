package Containers.PerformanceHistories;

import java.util.TreeMap;
import java.util.Date;

//TODO: add tests and serialize

public class CommunalPortfolioPerformanceHistory {
    private final TreeMap<Date, Object> treeQueue = new TreeMap<>();
    private final int size;
    private static final CommunalPortfolioPerformanceHistory instance = new CommunalPortfolioPerformanceHistory();
    private double totalDeposit = 0;

    private CommunalPortfolioPerformanceHistory() {
        size = 168; // Hours in a week
    }

    public void recordHistory(Double history) {
        treeQueue.put(new Date(), history);

        if (treeQueue.size() > size) {
            treeQueue.remove(treeQueue.firstKey());
        }
    }

    public static CommunalPortfolioPerformanceHistory getInstance() { return instance; }

    public double getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public TreeMap<Date, Object> getHistory() {return this.treeQueue;}

}
