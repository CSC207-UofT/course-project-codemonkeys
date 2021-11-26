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
public class Help extends Command {

    public Help(User initiator, ClientInterface client, String[] args) {
        super(initiator, client, args);
    }

    /**
     * Collect and output information on Commands
     * @returns true if successful
     */
    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        CommandManager cm = CommandManager.getInstance();
        List<Command> templates = cm.getCmdTemplates();
        // Use the args to try and create Commands, then format all their help strings for output
        if(this.args == null){
            for (Command cmd : templates)
                sb.append(cmd.help());
        }
        else {
            for (String s : this.args){
                for (Command cmd : templates){
                    if (s.trim().toLowerCase() == cmd.name().trim().toLowerCase())
                        sb.append(cmd.help() + "\n");
                }
            }
        }
        this.client.output(sb.toString());
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
