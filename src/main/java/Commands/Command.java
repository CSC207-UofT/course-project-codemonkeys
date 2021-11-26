package Commands;


/**
 * This is the Command Interface. All communications to business logic should be done through a Command.
 *
 * Author Langson Zhang
 * Date: Nov 24 2021
 * Version: 1.0
 */
public interface Command {

    /**
     * Executes the functionality of a Command
     * @returns true if successfully exectued, false otherwise
     */
    public boolean execute();

    /**
     * Gets the help string for this Command
     * @returns instructions on how to use this Command in String format
     */
    public String help();

    /**
     * Gets the name of this Command
     * @returns a name that can be used to match an input string to this Command
     */
    public String name();
}
