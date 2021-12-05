package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import UseCase.Managers.UserManager;
import Entities.Users.User;

public class CreateUser extends Command{

    public CreateUser(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        super(initiator, client, api, args);
    }
// arg[0] is the name of the user, the rest is the authorities
    @Override
    public boolean execute() {
        if (this.args.length == 0){
        return false;
    }
        UserManager um = UserManager.getInstance();
        if (this.args.length == 1){
            um.addUser(args[0]);
            System.out.println("Successfully created a common user named: " + args[0]);
            return true;
        }
        um.addUser(args[0]);
        User user = um.findUser(args[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("Successfully created a authorized user named: ").append(args[0]).append(", who has authority: ");
        for (int i = 1; i < args.length - 1; i++){
            user.addAuthority(args[i]);
            sb.append(args[i]).append(", ");
        }
        user.addAuthority(args[args.length - 1]);
        sb.append(args[args.length - 1]).append(".");
        System.out.println(sb);
        return true;
    }

    @Override
    public String help() {
        return "This is the CreateUser command.";
    }

    @Override
    public String name() {
        return "createuser";
    }
}
