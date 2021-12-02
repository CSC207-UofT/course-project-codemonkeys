package Interfaces.GraphicsPresenter;

import Assets.DataAccessInterface;
import Containers.PerformanceHistories.PortfolioPerformanceHistory;
import Containers.Portfolio;
import Managers.UserManager;

import javax.sound.sampled.Port;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Date;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextPanel implements Panel{
    Portfolio portfolio;
    DataAccessInterface api;

    public TextPanel(Portfolio portfolio, DataAccessInterface api) {
        this.portfolio = portfolio;
        this.api = api;
    }

    public String getData() {
        Date date = new Date();
        // Return the text displayed on the panel
        // TODO Connect with lower levels to get actual data

        double totalDeposit = PortfolioPerformanceHistory.getInstance().getTotalDeposit();
        double portfolioWorth = portfolio.getValue(api);
        double netProfit = portfolioWorth - totalDeposit;
        double profitPercent = netProfit / totalDeposit;
        int numUsers = UserManager.getInstance().numUser();

        String text = """
                        <html>
                                        
                        Total Investment DepositedP:<br>
                        US {0, number, currency}<br><br>
                                        
                        Current Portfolio Net Worth:<br>
                        US {1, number, currency}<br><br>
                                        
                        Current Net Profit:<br>
                        US {2, number, currency} ({3, number, percent})<br><br>
                                        
                        Total Invested Users: {4, number, integer}<br><br>
                        <html>
                        """;

        text = java.text.MessageFormat.format(text, totalDeposit, portfolioWorth,
                netProfit, profitPercent, numUsers);

        System.out.println(text);

        return text + "Timestamp: " + date.toString();
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
