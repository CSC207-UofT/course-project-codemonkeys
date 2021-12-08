package UseCase.GUIDataFetcher;

import Entities.Containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import UseCase.DataAccessInterfaceRelay;
import UseCase.Managers.AssetManager;
import UseCase.Managers.UserManager;

import java.util.Date;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */

    public static String getData(DataAccessInterfaceRelay api) {
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
