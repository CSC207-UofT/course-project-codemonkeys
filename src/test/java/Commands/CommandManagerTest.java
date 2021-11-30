package Commands;

import Interfaces.CommandLine;
import Interfaces.YahooFinanceStockAPI;
import Users.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class CommandManagerTest {
    private CommandManager cm = CommandManager.getInstance();


    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 500)
    public void testCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Create some Command profiles
        CommandProtocol cmd = new CommandProtocol(new User("u"), new CommandLine(), new YahooFinanceStockAPI(), new String[]{"buy", "sell", "checkprice"});
        CommandProtocol cmd2 = new CommandProtocol(new User("u"), new CommandLine(), new YahooFinanceStockAPI(), null);

        // Instantiate those Commands
        Help abc = Help.class.getConstructor(CommandProtocol.PROTOCOL).newInstance(cmd.PROFILE);
        Help abc2 = Help.class.getConstructor(CommandProtocol.PROTOCOL).newInstance(cmd2.PROFILE);

        // Test their execute methods
        System.out.println(abc.execute());
        System.out.println(abc2.execute());
    }
}