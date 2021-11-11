package UseCases.Commands;

import java.util.ArrayList;
import java.util.List;

public interface Command {
    /**
     * Executes the functionality of a Command
     * @returns true if successfully exectued, false otherwise
     */
    public boolean execute();

    /**
     * Gives help
     * @returns information on the command
     */
    public String help();
}
