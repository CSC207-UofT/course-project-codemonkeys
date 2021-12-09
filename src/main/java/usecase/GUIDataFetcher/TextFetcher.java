package usecase.GUIDataFetcher;

import entities.containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import usecase.DataAccessInterfaceUsecaseRelay;
import usecase.managers.AssetManager;
import usecase.managers.UserManager;

import java.util.Date;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */

    public static String getData(DataAccessInterfaceUsecaseRelay api) {
        Date date = new Date();

        double totalDeposit = CommunalPortfolioPerformanceHistory.getInstance().getTotalDeposit();
        double portfolioWorth = AssetManager.getInstance().getValue(api);
        double netProfit = portfolioWorth - totalDeposit;
        double profitPercent = netProfit / totalDeposit;
        int numUsers = UserManager.getInstance().numUser();

        String text = "<html>" +
                        "Total Deposited Investment:<br>" +
                        "US {0, number, currency}<br><br>" +

                        "Current Portfolio Net Worth:<br>" +
                        "US {1, number, currency}<br><br>" +

                        "Current Net Profit:<br>" +
                        "US {2, number, currency} ({3, number, percent})<br><br>" +

                        "Total Invested Entities.Users: {4, number, integer}<br><br>" +
                        "<html>";

        text = java.text.MessageFormat.format(text, totalDeposit, portfolioWorth,
                netProfit, profitPercent, numUsers);


        return text + "Timestamp: " + date;
    }
}
