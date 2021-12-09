package interfaces;

import controller.CommandParser;
import controller.ClientInterfaceC;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiscordClient implements ClientInterfaceC {

    public DiscordClient() throws LoginException, IOException {
        Path path = Paths.get("src/main/java/Interfaces/discord_secret_key");
        String token = Files.readString(path, StandardCharsets.US_ASCII);
        JDABuilder jda = JDABuilder.createDefault(token);
        jda.setActivity(Activity.watching("Stock Market"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new CommandParser(new YahooFinanceStockAPI(), new GraphicsUserInterface()));
        jda.build();
    }

    @Override
    public void input(String s) {
        //TODO
    }

    @Override
    public void output(String s) {
        //TODO
    }
}
