package Commands;

import Managers.UserManager;
import Users.Admin;
import Users.User;

public class CreateAdmin implements Command{
    public CreateAdmin() {
    }
    /**
     * Create new users
     * @param args list of users
     * @returns whether the execution was successful
     */

    @Override
    public boolean execute(User user, String[] args) {
        if(! UserManager.getInstance().isAdmin(user)){
            System.out.println("You are not an Admin!");
            return true;
        }
        if(args.length != 1) return false;
        UserManager.getInstance().addUser(new Admin(args[0]));
        System.out.println("New admin created!");
        return true;
    }

    @Override
    public String help() {
        return "To create a new admin, type 'your_name: createadmin new_user_name'";
    }

    @Override
    public String name() {
        return "createadmin";
    }

}
