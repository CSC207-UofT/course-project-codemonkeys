package Interfaces;

import Commands.Command;
import Commands.CommandManager;
import Managers.UserManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.net.CookieManager;
import java.util.List;

/**
 * This is a Class for parsing command send from customers.
 * It recognizes wish command is being called and
 * calls the "execute()" method in the corresponding command class.
 * User can also check the status of our discord bot
 *
 * Author Edward Li
 * Date: Nov 29 2021
 * Version: 1.0
 */
public class CommandParser extends ListenerAdapter {
    private String prefix = "!";
    private CommandManager commandManager = CommandManager.getInstance();
    private UserManager userManager = UserManager.getInstance();

    /**
     * Callback method when the bot receives message from users
     *  @param event represents a message from discord
     */
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        // String message = event.getMessage().getContentRaw();
        String[] message = event.getMessage().getContentRaw().split(" ");
        if (! event.getAuthor().isBot() && message[0].equals("!")) {
            String[] cmdArgs = new String[message.length - 1];
            System.arraycopy(message, 1, cmdArgs, 0, cmdArgs.length);
            parseCommand(cmdArgs, event.getAuthor().getName());
        }
    }

    /**
     * parse the command received by the discord bot
     *  @param cmdArgs is a list of all arguments accomplishing that command
     *  @param author is the person who send the command
     */
    public void parseCommand(String[] cmdArgs, String author) {
        String cmdName = cmdArgs[0];
        CommandProtocol commandProtocol =


        for (Command c : commandList) {
            if (!cmdName.equals(c.name())) continue;
            if(userObj == null) {
                System.out.println("No such user");
                continue;
            }
            boolean result = c.execute(userObj, cmdArgs);
            if(result) return true;
            System.out.println(c.help());
            return false;
        }
        System.out.println("No such command");
        return false;



        if (message[0].equalsIgnoreCase("$ hello bot")) {
            event.getMessage().reply("Hello " + ).queue();
        } else if (message.equalsIgnoreCase("$ check status")) {
            //event.getChannel().sendMessage("This bot is working").queue();
            event.getMessage().reply("This bot is working").queue();
        }
    }

}
