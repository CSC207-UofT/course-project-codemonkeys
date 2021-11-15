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
    public boolean execute(User user, String[] args) {
        if (! argCheck(args)) {
            System.out.println("The argument number is wrong. Use help to get syntax.");
            return false;
        }
        UserManager um = UserManager.getInstance(); //get the UserManager
        um.addUser(new User(args[0]));
        return true;
    }

    @Override
    public String help() {
        return "To create a new user, type 'your_name: createuser new_user_name'";
    }

    @Override
    public String name() {
        return "createUser";
    }

    public boolean argCheck(String[] args) {
        return args.length == 2;
    }
}
