package UseCase.Commands;

import Entities.Assets.DataAccessInterface;
import Interfaces.ClientInterface;
import Entities.Users.User;

/**
 *  TODO: Currently only used by CommandManager, can refactor later to be used by Command also (if we have time)
 *  Class for better organization of Command arguments.
 */
public class CommandProtocol {
    public static final Class[] PROTOCOL = new Class[]{
            User.class,
            ClientInterface.class,
            DataAccessInterface.class,
            String[].class
    };

    public final User INITIATOR;
    public final ClientInterface CLIENT;
    public final DataAccessInterface API;
    public final String[] ARGS;
    public final Object[] PROFILE;

    public CommandProtocol(User initiator, ClientInterface client, DataAccessInterface api, String[] args) {
        this.INITIATOR = initiator;
        this.CLIENT = client;
        this.API = api;
        this.ARGS = args;
        this.PROFILE = new Object[]{initiator, client, api,  (Object) args};
    }


}
