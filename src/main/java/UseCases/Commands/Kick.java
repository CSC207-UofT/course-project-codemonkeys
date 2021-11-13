package UseCases.Commands;

import Entities.User;
import UseCases.UserManager;

import java.util.ArrayList;

public class Kick implements Command{

    public Kick() {

    }

    /**
     * Kick the given users
     * @param args list of users
     * @returns whether the execution was successful
     */
    @Override
    public boolean execute(ArrayList args) {
        UserManager um = UserManager.getInstance(); //get the UserManager

        for(Object o : args){ //loop through the arguments
            if(o instanceof User){ //if its
                um.delUser((User) o);
            }
            else if(o instanceof String) {
                um.delUser((String) o);
            }
        }

        return true;
    }


    @Override
    public String help() {
        return "this is information for the Kick command";
    }
}
