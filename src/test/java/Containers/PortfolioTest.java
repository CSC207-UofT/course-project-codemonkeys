package Containers;

import Assets.Asset;
import Assets.CryptoCurrency;
import Assets.Currency;
import Assets.Stock;
import org.junit.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    Portfolio portfolio;
    Portfolio portfolio2;
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
        portfolio2 = new Portfolio();
        portfolio2.add(currency);
    }

    @After
    public void tearDown() {
        this.portfolio = null;
        this.currency = null;
        this.currency2 = null;
        this.stock = null;
        this.stock2 = null;
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
        double expected = 120 * 7 + 200 + 100 * 124 + 200 * 524;
        assertEquals(actual, expected);
    }


    @Test(timeout = 500)
    public void testsubAsset(){
        // Since the sub methods are the same for asset, transaction and vote, we only
        // need to test one of them.
        portfolio2.sub(currency);
        assert(portfolio2.getAssetList().isEmpty());


    }
}