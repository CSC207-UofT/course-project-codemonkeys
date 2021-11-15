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
    public boolean execute(User user, String[] args) {
        if (! UserManager.getInstance().isAdmin(user)) {
            System.out.println("You are not an Admin and have no permission!");
        }
        if (args.length != 1) return false;
        if(args[0].equals(user.getName())) {
            System.out.println("You cannot kick yourself!");
            return true;
        }
        User del = UserManager.getInstance().find(args[0]);
        if (del == null) System.out.println("User does not exist");
        UserManager.getInstance().delUser(user);
        System.out.println("Successfully delete the user!");
        return true;
    }


    @Override
    public String help() {
        return "this is information for the Kick command";
    }

    public String name() {
        return "kick";
    }
}
