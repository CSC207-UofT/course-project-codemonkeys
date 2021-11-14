package Commands;

import Users.User;
import Managers.UserManager;

import java.util.ArrayList;
import java.util.UUID;

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
            if(o instanceof UUID){

            }
        }

        return true;
    }


    @Override
    public String help() {
        return "this is information for the Kick command";
    }
}
