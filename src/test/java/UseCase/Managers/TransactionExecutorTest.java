package UseCase.Managers;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.Stock;
import Entities.Containers.Transaction;
import Interfaces.YahooFinanceStockAPI;
import Entities.Users.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionExecutorTest {

    private User user1 = new User("Richard");

    private Asset assetCash = new Currency(-1000,1, "Currency", "USD");
    private Asset assetStock = new Stock(1, 140, "Stock", "AMD");
    private Asset assetStock2 = new Stock(1, 140, "Stock", "AMD");
    private Asset assetStock3 = new Stock(7, 140, "Stock", "AMD");

    private Transaction transactionBuy = new Transaction(user1,assetCash, assetStock);
    private Transaction transactionSell = new Transaction(user1, assetStock3, assetCash);
    private Transaction transactionSell2 = new Transaction(user1, assetStock, assetCash);

//    private TransactionExecutor te = new TransactionExecutor();
    private YahooFinanceStockAPI api = new YahooFinanceStockAPI();

    private TransactionManager tm = TransactionManager.getInstance();
    private AssetManager am = AssetManager.getInstance();
    private VoteManager vm = VoteManager.getInstance();

    @Test
    public void testTransactionExecutor(){
        vm.addVote(transactionBuy, user1, true);
        vm.addVote(transactionSell, user1, true);

        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetCash);
        assertEquals(0, am.getTypeVolume("AMD"),0);
        assetStock2.updatePrice(api);
        double actual = 1000 / assetStock2.getPrice();
        TransactionExecutor.execute(transactionBuy, api);
        System.out.println(am.viewAssets(api));
        assertEquals(actual, am.getTypeVolume("AMD"), 0 );

        // check user portfolio
        assertEquals(1,user1.getUserPortfolio().getAssetList().size());
        System.out.println(user1.getUserPortfolio().toString());

        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetStock3);
        assetStock2.updatePrice(api);

        double original = 1000 / assetStock2.getPrice();
        double actual1 = 1000 / assetStock2.getPrice()+7;
        System.out.println(am.viewAssets(api));

        //make sure the asset is loaded
        assertEquals(actual1, am.getTypeVolume("AMD"), 0 );
        // check user portfolio
        assertEquals(1, user1.getUserPortfolio().getAssetList().size());
        TransactionExecutor.execute( transactionSell, api); // execute transaction

        assertEquals(original, am.getTypeVolume("AMD"), 0.01 );

        // check user portfolio
        assertEquals(1,user1.getUserPortfolio().getAssetList().size());
    }

}