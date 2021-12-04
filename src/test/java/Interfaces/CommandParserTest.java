package Interfaces;
import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import Assets.Stock;
import Commands.Command;
import Commands.CommandManager;
import Commands.CommandProtocol;
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

public class CommandParserTest {
    private final AssetManager am = AssetManager.getInstance();
    private final TransactionManager tm = TransactionManager.getInstance();
    private final VoteManager vm = VoteManager.getInstance();
    private final UserManager um = UserManager.getInstance();
    private final CommandManager cm = CommandManager.getInstance();
    Asset asset1, asset2, asset3, asset4, asset5, asset6;
    User user1, user2, user3, user4;
    Transaction transaction1, transaction2, transaction3;

    @Test
    public void testCreateUser() {
        String cmdName = "createuser";
        String[] argForCreateUser = {"Edward"};
        CommandProtocol commandProtocol = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), argForCreateUser);
        Command cmd = cm.generate(cm.find(cmdName), commandProtocol);
        boolean res = cmd.execute();
        assertTrue(res);
        assert(um.numUser() == 1);
        assert(um.findUser("Edward") != null);
        assert(um.findUser("jack") == null);
    }

    @Test
    public void testCreateMultipleUser() {
        String cmdName = "createuser";
        String[] argForCreateUser = {"Edward"};
        CommandProtocol commandProtocol = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), argForCreateUser);
        Command cmd = cm.generate(cm.find(cmdName), commandProtocol);
        boolean res = cmd.execute();
        String[] argForCreateUser2 = {"Java"};
        CommandProtocol commandProtocol2 = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), argForCreateUser2);
        Command cmd2 = cm.generate(cm.find(cmdName), commandProtocol);
        boolean res2 = cmd.execute();
        assertTrue(res);
        assertTrue(res2);
        assert(um.numUser() == 2);
    }
}
