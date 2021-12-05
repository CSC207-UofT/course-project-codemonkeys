package Interfaces;
import UseCase.Commands.Command;
import UseCase.Commands.CommandManager;
import UseCase.Commands.CommandProtocol;
import Controller.CommandParser;
import UseCase.Managers.*;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {
    private final AssetManager am = AssetManager.getInstance();
    private final TransactionManager tm = TransactionManager.getInstance();
    private final VoteManager vm = VoteManager.getInstance();
    private final UserManager um = UserManager.getInstance();
    private final CommandManager cm = CommandManager.getInstance();

    @Test
    public void testCreateMultipleUser() {
        String cmdName = "createuser";
        String[] argForCreateUser = {"Edward"};
        CommandProtocol commandProtocol = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), argForCreateUser);
        Command cmd = cm.generate(cm.find(cmdName), commandProtocol);
        boolean res = cmd.execute();
        String[] argForCreateUser2 = {"Java"};
        CommandProtocol commandProtocol2 = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), argForCreateUser2);
        Command cmd2 = cm.generate(cm.find(cmdName), commandProtocol2);
        boolean res2 = cmd2.execute();
        assertTrue(res);
        assertTrue(res2);
    }
}
