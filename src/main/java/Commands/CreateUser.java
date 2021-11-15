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
        if(args.length != 1) return false;
        UserManager.getInstance().addUser(new User(args[0]));
        System.out.println("New user created!");
        return true;
    }

    @Override
    public String help() {
        return "To create a new user, type 'your_name: createuser new_user_name'";
    }

    @Override
    public String name() {
        return "createuser";
    }

}
