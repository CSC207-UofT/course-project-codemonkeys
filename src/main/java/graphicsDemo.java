import Assets.Asset;
import Assets.Currency;
import Assets.Stock;
import Containers.PerformanceHistories.AssetPerformanceHistory;
import Containers.PerformanceHistories.PortfolioPerformanceHistory;
import Containers.Portfolio;
import Containers.Transaction;
import Interfaces.GraphicsUserInterface;
import Interfaces.YahooFinanceStockAPI;
import Managers.PerformanceHistoryManager;
import Managers.UserManager;
import Users.User;

public class graphicsDemo {
    public static void main(String[] args) {

//        String teslaName = "Tesla";
//        String teslaSymbol = "TSLA";
//        String currencyName = "Pool";
//        String currencySymbol = "USD";
//
//        Asset asset = new Asset(10, 1, teslaName, teslaSymbol);
//        Asset asset2 = new Asset(15, 1, teslaName,teslaSymbol);
//        Currency c1 = new Currency(10, 1, currencyName, currencySymbol);
//


        Asset currency = new Currency(1000, 1, "American Dollar", "USD");
        Asset stock = new Stock(100, 1, "Tesla", "TSLA");
        Asset stock2 = new Stock(200, 1, "Apple", "AAPL");
        Asset stock3 = new Stock(50, 1, "Microsoft", "MSFT");
        Portfolio portfolio = new Portfolio();
        portfolio.add(currency);
        portfolio.add(stock);
        portfolio.add(stock2);
        portfolio.add(stock3);

        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        User debbie = new User("Debbie");

        UserManager.getInstance().addUser(bob);
        UserManager.getInstance().addUser(alice);
        UserManager.getInstance().addUser(charlie);
        UserManager.getInstance().addUser(debbie);

        Transaction trans = new Transaction(bob, currency, stock2);

        YahooFinanceStockAPI api = new YahooFinanceStockAPI();

        // Deposite function and portfolio are not linked, here deposit is merely used to update portfolio value
        PerformanceHistoryManager.updateTotalDeposite(portfolio.getValue(api));

        for (int i = 0; i < 200; i++) {
            PerformanceHistoryManager.recordHistory(portfolio, api);
            double randFluctuation = 10000 * (0.5-Math.random());
            Asset randCurrency = new Currency(randFluctuation, 1, "American Dollar", "USD");

            portfolio.add(randCurrency);


        }

        GraphicsUserInterface.generateGraphics(portfolio, api);

    }
}
