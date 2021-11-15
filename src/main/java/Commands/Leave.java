package Commands;

import Managers.UserManager;
import Users.User;

import java.util.ArrayList;

public class Leave implements Command{

    public Leave() {
    }

    @Override
    public boolean execute(User user, String[] args) {
        if(UserManager.getInstance().getUserList().size() == 1) {
            System.out.println("You are the last user. You cannot leave");
            return true;
        }
        UserManager.getInstance().delUser(user);
        System.out.println("You have left the system");
        return true;
    }

    @Override
    public String help() {
        return "To leave, type 'username: leave'";
    }

    @Override
    public String name() {
        return "leave";
    }
}
