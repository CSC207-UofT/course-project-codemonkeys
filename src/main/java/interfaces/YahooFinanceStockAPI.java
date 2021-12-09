package interfaces;

import controller.DataAccessInterfaceRelay;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
/**
 * Provides real time data access to stock price from Yahoo Finance.
 *
 * Author Andrew Zhang
 * Date: Nov 25 2021
 * Version: 1.0
 */

public class YahooFinanceStockAPI implements DataAccessInterfaceRelay {
    /**
     * Updates stock price data given stock symbol as provided by Yahoo Finance's API (NASDAQ).
     * @param symbol Symbol of a stock
     * @return Price of the stock as double
     */

    @Override
    public double update(String symbol) {
        /*
          Updates stock price data given stock symbol.
         */
        try {
            Stock stock = YahooFinance.get(symbol);
            return stock.getQuote().getPrice().doubleValue();
        } catch (IOException ignored) { return 0.0; }
    }
}
