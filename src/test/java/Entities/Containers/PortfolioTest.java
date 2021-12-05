package Entities.Containers;

import Entities.Assets.Asset;
import Entities.Assets.Currency;
import Entities.Assets.Stock;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    Portfolio portfolio;
    Asset currency;
    Asset currency2;
    Asset stock;
    Asset stock2;

    @Before
    public void setUp() {
        currency = new Currency(120, 7, "American Dollar", "USD");
        currency2 = new Currency(200, 1, "Chinese Yuan", "CNY");
        stock = new Stock(100, 124, "Tesla", "TSLA");
        stock2 = new Stock(200, 524, "Apple", "APLE");
        portfolio = new Portfolio();
        portfolio.add(currency);
        portfolio.add(currency2);
        portfolio.add(stock);
        portfolio.add(stock2);

    }

    @After
    public void tearDown() {
        portfolio.sub(currency);
        portfolio.sub(currency2);
        portfolio.sub(stock2);
        portfolio.sub(stock);
        currency = null;
        currency2 = null;
        stock = null;
        stock2 = null;
    }

    @Test(timeout = 500)
    public void testSpecificValue(){
        double actual = portfolio.getValue("TSLA");
        double expected = 100 * 124;
        assertEquals(actual, expected);
    }

    @Test(timeout = 500)
    public void testTotalValue(){
        double actual = portfolio.getValue();
        double expected = (120 * 7) + 200 + (100 * 124) + (200 * 524);
        assertEquals(actual, expected);
    }


    @Test(timeout = 500)
    public void testsubAsset(){
        // Since the sub methods are the same for asset, transaction and vote, we only
        // need to test one of them.
        portfolio.sub(currency);
        assertFalse(portfolio.getAssetList().contains(currency));


    }
}