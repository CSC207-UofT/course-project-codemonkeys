package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import Entities.Users.User;
import UseCase.Managers.UserManager;

public class Kick extends Command{
    public Kick(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }
    /**
     * Fetches and displays price information to the Client.
     * this.args syntax: [String: symbol] Contain Name of the given user
     * @return if successful
     */

    @Override
    public boolean execute() {
        if (args.length != 1){return false;}

        if (!initiator.checkAuthority("Kick")) {
        System.out.println("You have no permission to kick person!");
        return true;
        }

        if(args[0].equals(initiator.getName())) {
            System.out.println("You cannot kick yourself!");
            return true;}

        User del = UserManager.getInstance().findUser(args[0]);
        if (del == null) System.out.println("User does not exist");
        UserManager.getInstance().delUser(args[0]);
        System.out.println("Successfully delete the user!");
        return true;
    }

    @Override
    public String help() {
        return "Kick: Remove an existing User from the system\n"+
                "Syntax: Kick [symbol]\n";
    }

    @Override
    public String name() {
        return "kick";
    }
}
