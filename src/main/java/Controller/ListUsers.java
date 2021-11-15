package Commands;

import Managers.UserManager;
import Users.User;

import java.util.List;

public class ListUsers implements Command{
    @Override
    public boolean execute(User user, String[] args) {
        if(!UserManager.getInstance().isAdmin(user)) {
            System.out.println("You do not have the permission!");
            return true;
        }
        List<User> users = UserManager.getInstance().getUserList();
        StringBuilder user_names = new StringBuilder("Other users: ");
        StringBuilder admin_names = new StringBuilder("Administrators: ");
        for(User aUser : users) {
            String name = aUser.getName();
            if(UserManager.getInstance().isAdmin(aUser))
                admin_names.append(name).append(' ');
            else
                user_names.append(name).append(' ');
        }
        System.out.println(admin_names.toString());
        System.out.println(user_names.toString());
        return true;
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String name() {
        return "listuser";
    }
}
