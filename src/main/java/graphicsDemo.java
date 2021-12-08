import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.Stock;
import Interfaces.GraphicsUserInterface;
import Interfaces.YahooFinanceStockAPI;
import UseCase.Managers.AssetManager;
import UseCase.Managers.PerformanceHistoryManager;
import UseCase.Managers.UserManager;
import Entities.Users.User;

import java.io.IOException;

public class graphicsDemo {
    public static void main(String[] args) throws IOException {

        YahooFinanceStockAPI api = new YahooFinanceStockAPI();

        Asset currency = new Currency(1000, 1, "American Dollar", "USD");
        Asset stock = new Stock(100, api.update("TSLA"), "Tesla", "TSLA");
        Asset stock2 = new Stock(200, api.update("AAPL"), "Apple", "AAPL");
        Asset stock3 = new Stock(50, api.update("MSFT"), "Microsoft", "MSFT");
        Asset stock4 = new Stock(40, api.update("GOOG"), "Google", "GOOG");

        AssetManager am = AssetManager.getInstance();

        am.addAsset(currency);
        am.addAsset(stock);
        am.addAsset(stock2);
        am.addAsset(stock3);
        am.addAsset(stock4);

        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        User debbie = new User("Debbie");

        UserManager.getInstance().addUser(bob);
        UserManager.getInstance().addUser(alice);
        UserManager.getInstance().addUser(charlie);
        UserManager.getInstance().addUser(debbie);


        PerformanceHistoryManager.updateTotalDeposite(am.getValue(api));

        for (int i = 0; i < 200; i++) {
            double randFluctuation = 10000 * (0.5-Math.random());
            Asset randCurrency = new Currency(randFluctuation, 1, "American Dollar", "USD");
            am.addAsset(randCurrency);
            PerformanceHistoryManager.recordHistory(api);
        }

        GraphicsUserInterface.generateImage(api);
        GraphicsUserInterface.generateGraphics(api);

    }
}
