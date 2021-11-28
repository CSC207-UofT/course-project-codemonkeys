package Managers;

import Assets.Asset;
import Containers.Transaction;
import Interfaces.YahooFinanceStockAPI;
import Users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionExecutorTest {

    private User user1 = new User("张三儿");

    private Asset assetCash = new Asset(1,-1000, "Currency", "USD");
    private Asset assetStock = new Asset(1, 140, "Stock", "AMD");
    private Asset assetStock2 = new Asset(1, 140, "Stock", "AMD");
    private Asset assetStock3 = new Asset(7, 140, "Stock", "AMD");

    private Transaction transactionBuy = new Transaction(user1,assetCash, assetStock);
    private Transaction transactionSell = new Transaction(user1, assetStock3, assetCash);
    private Transaction transactionSell2 = new Transaction(user1, assetStock, assetCash);

    private TransactionExecutor te = new TransactionExecutor();
    private YahooFinanceStockAPI api = new YahooFinanceStockAPI();

    private TransactionManager tm = TransactionManager.getInstance();
    private AssetManager am = AssetManager.getInstance();

    @Test
    public void testTransactionExecutor(){
        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetCash);
        assetStock2.updatePrice(api);
        double actual = 1000 / assetStock2.getPrice();
        te.execute(transactionBuy, api);
        assertEquals(actual, am.getTypeVolume("AMD"), 0 );

        // check user portfolio
        assertEquals(1,user1.getUserPortfolio().getAssetList().size());

        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetStock3);
        assetStock2.updatePrice(api);

        double original = 1000 / assetStock2.getPrice();
        double actual1 = 1000 / assetStock2.getPrice()+7;

        //make sure the asset is loaded
        assertEquals(actual1, am.getTypeVolume("AMD"), 0 );
        // check user portfolio
        assertEquals(1, user1.getUserPortfolio().getAssetList().size());
        te.execute( transactionSell, api); // execute transaction

        assertEquals(original, am.getTypeVolume("AMD"), 0 );

        // check user portfolio
        assertEquals(1,user1.getUserPortfolio().getAssetList().size());
    }
}