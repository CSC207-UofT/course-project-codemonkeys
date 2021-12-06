import Controller.Loader;
import Interfaces.DiscordClient;
import UseCase.Managers.AssetManager;
import UseCase.Managers.PerformanceHistoryManager;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws LoginException, IOException {
        Loader.load();
        DiscordClient discordClient = new DiscordClient();
    }
}
