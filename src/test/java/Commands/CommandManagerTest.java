package Commands;

import Interfaces.CommandParser;
import Interfaces.YahooFinanceStockAPI;
import Managers.UserManager;
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
        CommandManager cm = CommandManager.getInstance();
        UserManager um = UserManager.getInstance();

        // Example command String
        String cmdString = "help";

        // Create some Command profiles
        CommandProtocol profile1 = new CommandProtocol(new User("u"), new CommandParser(), new YahooFinanceStockAPI(), new String[]{"buy", "sell", "checkprice"});
        CommandProtocol profile2 = new CommandProtocol(new User("u"), new CommandParser(), new YahooFinanceStockAPI(), null);

        // Generate some commands
        Command cmd1 = cm.generate(cm.find(cmdString), profile1);
        Command cmd2 = cm.generate(cm.find(cmdString), profile2);

        // Check if they exist (they should)
        assert(cmd1 != null);
        assert(cmd2 != null);

        // Test their execute methods
        System.out.println(cmd1.execute());
        System.out.println(cmd2.execute());
    }

    @Test(timeout = 500)
    public void testCommandsCreateUser() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CommandManager cm = CommandManager.getInstance();
        UserManager um = UserManager.getInstance();

        // Example command String
        String cmdString = "createuser";

        // Create some Command profiles
        CommandProtocol profile1 = new CommandProtocol(new User("u"), new CommandParser(), new YahooFinanceStockAPI(), new String[]{"Edward"});

        // Generate some commands
        Command cmd1 = cm.generate(cm.find(cmdString), profile1);

        // Check if they exist (they should)
        assert(cmd1 != null);

        // Test their execute methods
        System.out.println(cmd1.execute());
    }
}