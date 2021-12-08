package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import UseCase.ClientInterface.ClientInterface;
import Entities.Users.User;

import java.util.List;


/**
 * The "Help" Command. This command returns information on how to use UseCase.Commands
 */
public class Help extends Command {

    public Help(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }

    /**
     * Collect and output information on UseCase.Commands
     * @return true if successful
     */
    @Override
    public boolean execute() {
        StringBuilder sb = new StringBuilder();
        CommandManager cm = CommandManager.getInstance();
        List<Command> templates = cm.getCmdTemplates();
        // Use the args to try and create UseCase.Commands, then format all their help strings for output
        if(this.args == null){
            for (Command cmd : templates)
                sb.append(cmd.help());
        }
        else {
            for (String s : this.args){
                for (Command cmd : templates){
                    if (s.trim().equalsIgnoreCase(cmd.name().trim()))
                        sb.append(cmd.help()).append("\n");
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
