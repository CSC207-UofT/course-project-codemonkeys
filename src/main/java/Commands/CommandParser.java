package Commands;
import java.util.List;
import java.util.Objects;

public class CommandParser {
    private List<Command> commandList= CommandManager.getInstance().getTemplates();

    public boolean parseCommand(String user, String args) {
        String[] argList = args.split(" ");
        String cmdName = argList[0];
        for (Command c : commandList) {
            if (cmdName.equals(c.name())) {
                boolean result = c.execute(user, argList);
                if(result) return true;
                System.out.println("No such command");
                return false;
            }
        }
        System.out.println("No such command");
        return false;
    }
}