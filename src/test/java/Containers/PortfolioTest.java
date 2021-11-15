package Containers;

import Assets.Asset;
import org.junit.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    Portfolio portfolio;
    Asset currency;
    Asset currency2;
    Asset stock;
    Asset stock2;

    @Before
    public void setUp() {
        /**
         * Setup:
         * 1. Make some new assets
         * 2. Make a new portfolio
         * 3. Add the assets to the portfolio
         */
//        currency = new Asset(111, 1, new Currency());
//        currency2 = new Asset(222, 1, new Currency());
//        stock = new Asset(333, 2, new Stock());
//        stock2 = new Asset(444, 2, new Stock());
//        portfolio = new Portfolio();
//        portfolio.put(currency.getId(), currency);
//        portfolio.put(currency2.getId(), currency2);
//        portfolio.put(stock.getId(), stock);
//        portfolio.put(stock2.getId(), stock2);
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testGetTypes(){
        /**
         * Testing:
         * 1. Get all assets of Currency type from the portfolio
         * 2. Test if the portfolio is empty
         * 3. Test if assets contains currency
         * 4. and currency2
         * 5. Test if assets does not contain stock
         * 6. and stock2
         */
//        List<Asset<Currency>> assets = portfolio.getAssetsOfType(Currency.class); // 1
//        assertEquals(false, portfolio.isEmpty()); // 2
//        assertEquals(true, assets.contains(currency)); // 3
//        assertEquals(true, assets.contains(currency2)); // 4
//        assertEquals(false, assets.contains(stock)); // 5
//        assertEquals(false, assets.contains(stock2)); // 6
    }
}