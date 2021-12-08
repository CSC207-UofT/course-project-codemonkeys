package UseCase.Commands;


import Entities.Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import Entities.Users.User;

/**
 * This is the Command Interface. All communications to business logic should be done through a Command.
 */
public abstract class Command {

    protected final User initiator; // who
    protected final ClientInterface client; // where
    protected final String[] args; // what
    protected final DataAccessInterface api; // How

    /**
     * Basic constructor for a Command.
     * @param initiator is "who" called this Command
     * @param client is "where" the call came from
     * @param args is "what" to do
     */
    public Command(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        this.initiator = initiator;
        this.client = client;
        this.args = args;
        this.api = api;
    }

    /**
     * Executes the functionality of a Command
     * @returns true if successfully executed, false otherwise
     */
    public abstract boolean execute();

    /**
     * Gets the help string for this Command
     * @returns instructions on how to use this Command in String format
     */
    public abstract String help();

    /**
     * Gets the name of this Command
     * @returns a name that can be used to match an input string to this Command
     */
    public abstract String name();
}
