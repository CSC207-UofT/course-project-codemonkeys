import Controller.Loader;
import Interfaces.DiscordClient;

import javax.security.auth.login.LoginException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws LoginException, IOException {
        Loader.load();
        DiscordClient discordClient = new DiscordClient();
    }
}
