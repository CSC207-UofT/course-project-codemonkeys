/**
 * @File: CommandManager.java
 * @Brief: Class for centralized manipulation of Commands
 *
 * @Author: Langson Zhang for CSC207 codeMonkeys
 * @Date: Nov 11 2021
 * @Version: 1.0
 */

package Commands;

import org.reflections.Reflections;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CommandManager {
    private static CommandManager instance; // The instance

    Set<Class<? extends Command>> cmdClasses; // Class objects for the commands
    List<Command> cmdTemplates; // Template instances of the commands

    //______________________________________________ Constructors ______________________________________________________

    private CommandManager() {
        init(); // Initialize the class variables
    }

    static {
        instance = new CommandManager(); // Static initializer
    }

    //_________________________________________________ Methods ________________________________________________________

    /**
     * Helper method for the initialization phase
     */
    private void init() {
        // We use the reflection api to scan for all subtypes of Command
        cmdClasses = new Reflections(Command.class).getSubTypesOf(Command.class);
        cmdTemplates = new ArrayList<Command>();

        // Then we try to instantiate those Classes
        try{
            for (Class c : cmdClasses) {
                cmdTemplates.add((Command) c.getConstructor().newInstance());
            }
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    /**
     * Gets the singleton instance
     * @returns the instance
     */
    public static CommandManager getInstance(){
        return instance;
    }

    /**
     * Gets the templates
     * @returns the templates
     */
    public List<Command> getTemplates(){
        return this.cmdTemplates;
    }
}
