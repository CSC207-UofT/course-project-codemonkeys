package Commands;

import Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import Managers.UserManager;
import Users.User;

public class Leave extends Command{
    public Leave(User initiator, ClientInterface client, String[] args, DataAccessInterface api) {
        super(initiator, client, args, api);
    }

    @Override
    public boolean execute() {
        UserManager.getInstance().delUser(initiator);
        System.out.println("You have left the system");
        return true;
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }
}
