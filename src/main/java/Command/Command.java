package Command;

import Users.User;

public interface Command {
    /**
     * Executes the functionality of a Command
     * @returns true if successfully exectued, false otherwise
     * @param args
     */

    public boolean execute(User user, String[] args);

    /**
     * Gives help
     * @returns information on the command
     */
    public String help();

    public String name();
}
