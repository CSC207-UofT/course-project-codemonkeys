package Commands;
import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import Assets.Stock;
import Containers.Transaction;
import Containers.Vote;
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
    Asset asset1, asset2, asset3, asset4, asset5;
    User user1, user2, user3, user4;
    Transaction transaction1, transaction2;
    ClientInterface client = new ClientInterface() {
        @Override
        public void input(String s) {

        }

        @Override
        public void output(String s) {

        }
    };
    DataAccessInterface api = new YahooFinanceStockAPI();
    UpVote upVote1, upVote2, upVote3;
    DownVote downVote1, downVote2, downVote3;

    @Before
    public void setUp() {
        asset1 = new Stock(20, 500, "tesla", "TSLA");
        asset2 = new Currency(-10000, 1, "usDollar", "USD");
        asset3 = new Stock(5, 100, "apple", "AAPL");
        asset4 = new Currency(-500, 1, "usDollar", "USD");
        asset5 = new Currency(100000, 1, "usDollar", "USD");
        am.addAsset(asset5);
        user1 = new User("initiator1");
        user2 = new User("initiator2");
        user3 = new User("voter1");
        user4 = new User("voter2");
        transaction1 = new Transaction(user1, asset2, asset1);
        transaction2 = new Transaction(user2, asset4, asset3);
        tm.addTransaction(transaction1);
        tm.addTransaction(transaction2);
        vm.addVote(transaction1, user1, true);
        vm.addVote(transaction2, user2, true);
        upVote1 = new UpVote(user2, client, new String[]{transaction1.getId().toString()}, api);
        upVote2 = new UpVote(user3, client, new String[]{transaction1.getId().toString()}, api);
        upVote3 = new UpVote(user4, client, new String[]{transaction1.getId().toString()}, api);
        downVote1 = new DownVote(user1, client, new String[]{transaction2.getId().toString()}, api);
        downVote2 = new DownVote(user3, client, new String[]{transaction2.getId().toString()}, api);
        downVote3 = new DownVote(user4, client, new String[]{transaction2.getId().toString()}, api);
    }
//    @After
//    public void tearDown() {
//        vm.removeTrans(transaction1);
//        vm.removeTrans(transaction2);
//        tm.remove(transaction1.getId());
//        tm.remove(transaction2.getId());
//        am.delAsset(asset1);
//        am.delAsset(asset2);
//        am.delAsset(asset3);
//        am.delAsset(asset4);
//        am.delAsset(asset5);
//        user1.getUserPortfolio().sub(asset1);
//        user2.getUserPortfolio().sub(asset3);
//        user1.getUserPortfolio().sub(transaction1);
//        user2.getUserPortfolio().sub(transaction1);
//        user3.getUserPortfolio().sub(transaction1);
//        user4.getUserPortfolio().sub(transaction1);
//        user1.getUserPortfolio().sub(transaction2);
//        user2.getUserPortfolio().sub(transaction2);
//        user3.getUserPortfolio().sub(transaction2);
//        user4.getUserPortfolio().sub(transaction2);
//    }

    @Test
    public void testTransPassed(){
        upVote1.execute();
        assertFalse(am.containAsset(asset1));
        upVote2.execute();
        assertEquals(3, vm.numVoters(transaction1));
        assertTrue(am.containAsset(asset1));
        assertFalse(tm.checkTransactions(transaction1));
//        assertTrue(tm.checkTransactions(transaction2));
//        assertTrue(user1.getUserPortfolio().getAssetList().contains(asset1));
    }
}
