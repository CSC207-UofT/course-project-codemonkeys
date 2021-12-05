package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import UseCase.Managers.UserManager;
import Entities.Users.User;

public class Leave extends Command{
    public Leave(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }

    @Override
    public boolean execute() {
        UserManager.getInstance().delUser(initiator);
        System.out.println("You have left the system");
        return true;
    }

    @Override
    public String help() {
        return "This is the Leave command.";
    }

    @Override
    public String name() {
        return "leave";
    }
}
