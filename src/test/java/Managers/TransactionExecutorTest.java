package Managers;

import Assets.Asset;
import Containers.Transaction;
import Interfaces.YahooFinanceStockAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionExecutorTest {

    private Asset assetCash = new Asset(1,1000, "Currency", "USD");
    private Asset assetStock = new Asset(1, 140, "Stock", "AMD");
    private Asset assetStock2 = new Asset(1, 140, "Stock", "AMD");

    private Transaction transactionBuy = new Transaction(null,assetCash, assetStock);
    private Transaction transactionSell = new Transaction(null, assetStock, assetCash);
    private YahooFinanceStockAPI api = new YahooFinanceStockAPI();

    private TransactionManager tm = TransactionManager.getInstance();
    private AssetManager am = AssetManager.getInstance();

    @Test
    public void testTransactionExecutorBuy(){
        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetCash);
        assetStock2.updatePrice(api);
        double actual = 1000 / assetStock2.getPrice();
        tm.executeTransaction(true, transactionBuy, api);
        assertEquals(actual, am.getTypeVolume("AMD"), 0 );
    }

    @Test
    public void testTransactionExecutorSell(){
        tm.addTransaction(transactionBuy);
        tm.addTransaction(transactionSell);

        am.addAsset(assetStock);
        assetStock2.updatePrice(api);
        double actual = assetStock2.getPrice();
        assertEquals(1, am.getTypeVolume("AMD"), 0 );

        tm.executeTransaction(true, transactionSell, api);
        assertEquals(0, am.getTypeVolume("AMD"), 0 );
    }
}