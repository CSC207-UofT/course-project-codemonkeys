import Assets.Asset;
import Assets.AssetType;
import Assets.Stock;
import Commands.Help;
import Commands.Kick;
import Containers.Portfolio;
import Interfaces.CommandLine;
import Interfaces.GraphicsUserInterface;
import Interfaces.YahooFinanceAPI;
import Managers.AssetMangers.AssetPriceManager;
import Managers.UserManager;
import Users.User;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main1 {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        YahooFinanceAPI yahoo = new YahooFinanceAPI();

        Stock tesla = new Stock();
        tesla.symbol = "TSLA";
        Asset teslaStock = new Asset(10,0.0, tesla);

        Stock google = new Stock();
        google.symbol = "GOOGL";
        Asset googleStock = new Asset(7,0.0, google);

        Stock apple = new Stock();
        apple.symbol = "AAPL";
        Asset appleStock = new Asset(7,0.0, apple);

        Stock microsoft = new Stock();
        microsoft.symbol = "MSFT";
        Asset microsoftStock = new Asset(7,0.0, microsoft);

        Portfolio portfolio = new Portfolio();
        portfolio.add(microsoftStock);
        portfolio.add(appleStock);
        portfolio.add(googleStock);
        portfolio.add(teslaStock);
        portfolio.updateAllAssets(yahoo);

        User alice = new User("Alice");
        alice.setVotingPower(1000);
        User bob = new User("Bob");
        bob.setVotingPower(1200);
        User charlie = new User("Charlie");
        charlie.setVotingPower(1000);
        User diane = new User("Diane");
        diane.setVotingPower(900);
        User edward = new User("Edward");
        edward.setVotingPower(2010);

        UserManager userManager = Managers.UserManager.getInstance();
        userManager.addUser(alice);
        userManager.addUser(bob);
        userManager.addUser(charlie);
        userManager.addUser(diane);
        userManager.addUser(edward);




        GraphicsUserInterface.presentGraphics(portfolio);

    }
}