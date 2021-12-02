package Managers;

import Containers.PerformanceHistories.PortfolioPerformanceHistory;

public class PerformanceHistoryManager {

    /**
     * Contains variables and methods used to evaluate the performance of the communal portfolio.
     */

    public static void updateTotalDeposite(double depositeVolume) {
        PortfolioPerformanceHistory pph = PortfolioPerformanceHistory.getInstance();
        pph.setTotalDeposit(pph.getTotalDeposit() + depositeVolume);
    }






}
