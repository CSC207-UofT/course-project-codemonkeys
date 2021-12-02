package Interfaces.GraphicsPresenter;

import Containers.PerformanceHistories.PortfolioPerformanceHistory;
import Containers.Portfolio;
import Managers.UserManager;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextPanel implements Panel{
    Portfolio portfolio;

    public TextPanel(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getData() {
        Date date = new Date();
        // Return the text displayed on the panel
        // TODO Connect with lower levels to get actual data

        double totalDeposit = PortfolioPerformanceHistory.getInstance().getTotalDeposit();
        double portfolioWorth = portfolio.getValue();
        double netProfit = portfolioWorth - totalDeposit;
        double profitPercent = netProfit / totalDeposit;
        int numUsers = UserManager.getInstance().numUser();

        String text = """
                                        
                        US ${0, number, currency} Total Investment Deposited
                                        
                        Current Portfolio Net Worth: US ${1, number, currency}
                                        
                        Current Net Profit: US ${2, number, currency} ({3, number, percent}%)
                                        
                        Total Invested Users: {4, number, integer}
                                        
                        """;

        text = java.text.MessageFormat.format(text, totalDeposit, portfolioWorth,
                netProfit, profitPercent, numUsers);

        return text + "Timestamp: " + date.toString();
    }

    public JPanel getPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel( getData());
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        label.setForeground(Color.black);
        panel.add(label);
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.white);
        return panel;
    }
}
