package Commands;
import Managers.UserManager;
import Users.User;

import java.util.List;
import java.util.Objects;

public class CommandParser {
    private List<Command> commandList= CommandManager.getInstance().getTemplates();

    public boolean parseCommand(String user, String args) {
        String[] argList = args.split(" ");
        String cmdName = argList[0];
        String[] cmdArgs = new String[argList.length - 1];
        System.arraycopy(argList, 1, cmdArgs, 0, cmdArgs.length);
        for (Command c : commandList) {
            if (!cmdName.equals(c.name())) continue;
            User userObj = UserManager.getInstance().find(user);
            if(userObj == null) {
                System.out.println("No such user");
                continue;
            }
            boolean result = c.execute(userObj, cmdArgs);
            if(result) return true;
            System.out.println(c.help());
            return false;
        }
        System.out.println("No such command");
        return false;
    }
}