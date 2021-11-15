package Managers;

import Assets.Asset;
import Assets.Stock;
import Containers.Transaction;
import Containers.Vote;
import Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionManagerTest {
    private Transaction[] transactions;
    private Asset[] assets;
    private TransactionManager tm = TransactionManager.getInstance();

    @Before
    public void setUp() {
        /**
         * Setup
         * 1. Clear TransactionManager
         * 2. Refresh transactions and assets
         * 3. Make assets with volume = i and price = i*10
         * 4. Make transactions with those assets
         * 5. Put those transactions in the transaction manager
         */
        tm.clear();
        transactions = new Transaction[10];
        assets = new Asset[10];

        for (int i = 0; i < 10; i++){
            assets[i] = new Asset(i, 10*i, null);
            transactions[i] = new Transaction(null, assets[i], assets[i]);
            tm.put(transactions[i].getId(), transactions[i]);
        }

    }

    @After
    public void tearDown() {

    }

    @Test(timeout = 500)
    public void testTransactionManager(){
        /**
         * Testing:
         * 1. Remove a transaction
         * 2. Test to see if the transaction is still in the TransactionManager
         * 3. Test to see if the price of the 9th transaction added is the same as how we set it
         * 4. Test to see if TransactionManager now has only 9 transactions
         * 5. Test to sse if all the Transactions are correct by checking if the assets have volume = 0 mod 10
         */
        tm.remove(transactions[0].getId()); // 1
        assertEquals(false, tm.containsValue(transactions[0]) || tm.containsKey(transactions[0].getId())); // 2
        assertEquals(90, tm.get(transactions[9].getId()).getIn().getPrice()); // 3
        assertEquals(9, tm.size()); // 4
        for(Transaction t : tm.values()){ // 5
            assertEquals(0, t.getIn().getPrice() % 10);
        }
    }
}