package Commands;
import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import Assets.Stock;
import Containers.Transaction;
import Interfaces.ClientInterface;
import Interfaces.YahooFinanceStockAPI;
import Managers.AssetManager;
import Managers.TransactionManager;
import Managers.UserManager;
import Managers.VoteManager;
import Users.User;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class UpDownVoteTest {
    private final AssetManager am = AssetManager.getInstance();
    private final TransactionManager tm = TransactionManager.getInstance();
    private final VoteManager vm = VoteManager.getInstance();
    private final UserManager um = UserManager.getInstance();
    Asset asset1, asset2, asset3, asset4, asset5, asset6;
    User user1, user2, user3, user4;
    Transaction transaction1, transaction2, transaction3;
    ClientInterface client = new ClientInterface() {
        @Override
        public void input(String s) {

        }

        @Override
        public void output(String s) {

        }
    };
    DataAccessInterface api = new YahooFinanceStockAPI();
    UpVote upVote1, upVote2, upVote3, upVote4, upVote5, upVote6;
    DownVote downVote1, downVote2, downVote3;

    @Before
    public void setUp() {
        asset1 = new Stock(20, 500, "tesla", "TSLA");
        asset2 = new Currency(-10000, 1, "usDollar", "USD");
        asset3 = new Stock(5, 100, "apple", "AAPL");
        asset4 = new Currency(-500, 1, "usDollar", "USD");
        asset5 = new Currency(100000, 1, "usDollar", "USD");
        asset6 = new Currency(0, 1, "usDollar", "USD");
        am.addAsset(asset5);
        user1 = new User("initiator1");
        user2 = new User("initiator2");
        user3 = new User("voter1");
        user4 = new User("voter2");
        transaction1 = new Transaction(user1, asset2, asset1);
        transaction2 = new Transaction(user2, asset4, asset3);
        transaction3 = new Transaction(user1, asset1, asset6);
        tm.addTransaction(transaction1);
        tm.addTransaction(transaction2);
        tm.addTransaction(transaction3);
        vm.addVote(transaction1, user1, true);
        vm.addVote(transaction2, user2, true);
        vm.addVote(transaction3, user1, true);
        upVote1 = new UpVote(user2, client, api, new String[]{transaction1.getId().toString()});
        upVote2 = new UpVote(user3, client, api, new String[]{transaction1.getId().toString()});
        upVote3 = new UpVote(user4, client, api, new String[]{transaction1.getId().toString()});
        downVote1 = new DownVote(user1, client, api, new String[]{transaction2.getId().toString()});
        downVote2 = new DownVote(user3, client, api, new String[]{transaction2.getId().toString()});
        downVote3 = new DownVote(user4, client, api, new String[]{transaction2.getId().toString()});
        upVote4 = new UpVote(user2, client, api, new String[]{transaction3.getId().toString()});
        upVote5 = new UpVote(user3, client, api, new String[]{transaction3.getId().toString()});
        upVote6 = new UpVote(user4, client, api, new String[]{transaction3.getId().toString()});
    }

    @Test
    public void testExecuteVote(){
        // this is a buy transaction transaction1
        upVote1.execute(); // Vote added and Only 2 votes for transaction1, won't execute
        assertFalse(am.containAsset(asset1)); // asset should not be added to AssetManager if the transaction didn't execute
        assertFalse(am.containAsset(asset2));

        assertTrue(tm.checkTransactions(transaction1)); // transaction should not be removed from the TransactionManager if the transaction didn't execute

        assertFalse(user1.getUserPortfolio().getTransactionList().contains(transaction1));// transaction should not be added to user's portfolio if the transaction didn't execute

        assertFalse(user1.getUserPortfolio().getAssetList().contains(asset1)); // asset should not be added to INITIATOR's portfolio if the transaction didn't execute

        upVote2.execute(); // Vote added, reach the condition for a buy transaction to pass, transaction execute

        assertTrue(am.containAsset(asset1)); // asset is added into AssetManager
        assertTrue(am.containAsset(asset2));

        assertFalse(tm.checkTransactions(transaction1)); // transaction is removed from the TransactionManager

        assertTrue(user1.getUserPortfolio().getAssetList().contains(asset1)); // asset(stock bought) is added to INITIATOR's portfolio but not other voter's portfolio
        assertFalse(user1.getUserPortfolio().getAssetList().contains(asset2));
        assertFalse(user2.getUserPortfolio().getAssetList().contains(asset1));

        assertTrue(user1.getUserPortfolio().getTransactionList().contains(transaction1)); // transaction is added to all voter's portfolio
        assertTrue(user2.getUserPortfolio().getTransactionList().contains(transaction1));

        upVote3.execute(); // should give message: Cannot find the transaction

        // this is the second buy transaction transaction2, it will not execute since it does not pass execute checker
        downVote1.execute();
        downVote2.execute();
        downVote3.execute();
        assertTrue(tm.checkTransactions(transaction2));

        // this is a sell transaction transaction3
        upVote4.execute(); // two votes add but only 3 vote for this transaction, a sell transaction needs at least 4 votes to pass
        upVote5.execute();
        assertTrue(tm.checkTransactions(transaction3));
        assertTrue(am.containAsset(asset1));
        assertTrue(am.containAsset(asset2));
        assertFalse(am.containAsset(asset6));


        upVote6.execute();// one more vote added and reached the sell transaction pass condition, transaction executes

        assertFalse(tm.checkTransactions(transaction3)); // transaction is removed from the TransactionManager after execute

        assertFalse(am.containAsset(asset1)); // The sold stock asset is removed from the AssetManager, the USD we get from the transaction is added into the AssetManager
        assertTrue(am.containAsset(asset6));
        assertTrue(am.containAsset(asset2));

        assertFalse(user1.getUserPortfolio().getAssetList().contains(asset1));// The sold stock is removed from the INITIATOR's portfolio
    }
}
