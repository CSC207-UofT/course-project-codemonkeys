package Commands;

import Interfaces.ClientInterface;
import Users.User;

import java.util.List;
import java.util.Locale;


/**
 * The "Help" Command. This command returns information on how to use Commands
 *
 * Author Langson Zhang
 * Date: Nov 24 2021
 * Version: 1.0
 */
public class Help implements Command {


    /**
     * Collect and output information on Commands
     * @param user called this Command
     * @param client is where the call to this Command came from
     * @param args are the Commands to collect information for, or null to query all
     * @returns true if successful
     */
    @Override
    public boolean execute(User user, ClientInterface client, String[] args) {
        StringBuilder sb = new StringBuilder();
        CommandManager cm = CommandManager.getInstance();
        List<Command> templates = cm.getCmdTemplates();
        // Use the args to try and create Commands, then format all their help strings for output
        if(args == null){
            for (Command cmd : templates)
                sb.append(cmd.help());
        }
        else {
            for (String s : args){
                for (Command cmd : templates){
                    if (s.trim().toLowerCase() == cmd.name().trim().toLowerCase())
                        sb.append(cmd.help() + "\n");
                }
            }
        }
        client.output(sb.toString());
        return true;
    }

    @Override
    public String help() {
        return "This is the help command.";
    }

    @Override
    public String name() {
        return "help";
    }
}
