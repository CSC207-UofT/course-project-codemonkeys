package Commands;

import java.util.ArrayList;

public interface Command {
    /**
     * Executes the functionality of a Command
     * @returns true if successfully exectued, false otherwise
     * @param args
     */
    public boolean execute(String user, String[] args);

    /**
     * Gives help
     * @returns information on the command
     */
    public String help();

    public String name();
}
