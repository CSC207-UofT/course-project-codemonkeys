package Interfaces;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordClient implements ClientInterface{

    public DiscordClient() throws LoginException{
        JDABuilder jda = JDABuilder.createDefault("OTEyMTQ0NTE2NTc0NzQ4Njcy.YZrqxw.RgXlPR8NqYFDqjnxdcvmEzet0KU");
        jda.setActivity(Activity.watching("Stock Market"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new CommandParser());
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
