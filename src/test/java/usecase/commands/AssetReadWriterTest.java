package usecase.commands;

import entities.assets.Asset;
import entities.assets.CryptoCurrency;
import entities.assets.Currency;
import entities.assets.Stock;
import usecase.managers.AssetManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AssetReadWriterTest {
    private Stock stock1;
    private Currency currency1;
    private CryptoCurrency currency2;
    private AssetReadWriter arw;
    private AssetManager manager;


    @Before
    public void setUp() {
        stock1 = new Stock(15, 15,  "Tesla", "TSLA");
        currency1 = new Currency(1, 7, "American Dollar", "USD");
        currency2 = new CryptoCurrency(2, 7, "Crypto", "CYPT");
        manager = AssetManager.getInstance();
        manager.addAsset(stock1);
        manager.addAsset(currency1);
        manager.addAsset(currency2);
        arw = new AssetReadWriter();

    }

    @After
    public void tearDown() {
        for (Asset asset: manager.getAssetList()){
            manager.removeAsset(asset);
        }
        stock1 = null;
        currency1 = null;
        currency2 = null;
        arw = null;
    }

    @Test(timeout = 500)
    public void testReadWrite() throws IOException, ClassNotFoundException {
        arw.saveToFile("./assetManager.ser", manager);
        AssetManager newManager = arw.readFromFile("./assetManager.ser");
        assert(newManager.getTypeVolume("TSLA") == manager.getTypeVolume("TSLA")
                && manager.getTypeVolume("TSLA") == 15);
        assert(newManager.getTypeVolume("USD") == manager.getTypeVolume("USD")
                && manager.getTypeVolume("USD") == 1);
        assert(newManager.getTypeVolume("CYPT") == manager.getTypeVolume("CYPT")
                && manager.getTypeVolume("CYPT") == 2);
    }
}
