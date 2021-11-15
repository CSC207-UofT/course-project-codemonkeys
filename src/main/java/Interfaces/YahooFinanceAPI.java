package Interfaces;

import UseCases.DataAccessInterface;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class YahooFinanceAPI implements DataAccessInterface {

    @Override
    public double getUpdate(String symbol) {
        try {
            Stock stock = YahooFinance.get(symbol);
            return stock.getQuote().getPrice().doubleValue();
        } catch (IOException ignored) { return 0.0; }
    }

    public double getCureentPrice(String name) {
        return getUpdate(name);
    }
}
