package Commands;
import Users.User;
import Managers.UserManager;

import java.util.ArrayList;
import java.util.UUID;

public class CreateUser implements Command{
    public CreateUser() {
    }
    /**
     * Create new users
     * @param args list of users
     * @returns whether the execution was successful
     */

    @Override
    public boolean execute(String user, String[] args) {
        UserManager um = UserManager.getInstance(); //get the UserManager

        for(Object o : args){ //loop through the arguments
            if (!(o instanceof User)){ //if not create before
                um.addUser((User) o);
            }
            else {return false;
            }
        }
        return true;
    }

    @Override
    public String help() {
        return "this is info for the create user command";
    }

    @Override
    public String name() {
        return "createUser";
    }
}
