package Presenters;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import UseCase.Managers.UserManager;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import UseCase.Managers.AssetManager;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextPanel implements Panel {
    DataAccessInterface api;

    public TextPanel(DataAccessInterface api) {
        this.api = api;
    }

    public String getData() {
        Date date = new Date();
        // Return the text displayed on the panel
        // TODO Connect with lower levels to get actual data

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

    public JPanel getPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(getData());
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        label.setForeground(Color.black);
        panel.add(label);
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.white);
        return panel;
    }
}
