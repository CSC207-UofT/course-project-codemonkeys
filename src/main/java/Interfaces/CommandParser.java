package Interfaces;

import Commands.Command;
import Commands.CommandManager;
import Commands.CommandProtocol;
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
public class CommandParser extends ListenerAdapter implements ClientInterface{
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
            String result = parseCommand(cmdArgs, event.getAuthor().getName());
            event.getMessage().reply(result).queue();
        }
    }

    /**
     * parse the command received by the discord bot
     *  @param cmdArgs is a list of all arguments accomplishing that command
     *  @param author is the person who send the command
     */
    public String parseCommand(String[] cmdArgs, String author) {
        if(cmdArgs.length == 0) return("Your command is empty.");
        String cmdName = cmdArgs[0];
        String[] ArgWithoutCmd = new String[cmdArgs.length - 1];
        // ArgWithoutCmd[0] = author;
        for (int i=1; i<cmdArgs.length; i++)
        {
            ArgWithoutCmd[i] = cmdArgs[i];
        }
        if(cmdName.equals("checkstatus")) return("This bot is working");
        if(cmdName.equals("hello")) return("Hello! " + author);
//        if(userManager.findUser(author) != null){
//            return("You are not a user of this system. Use createuser to create a new user.");
//        }
        CommandProtocol commandProtocol = new CommandProtocol(userManager.findUser(author), new CommandParser(), new YahooFinanceStockAPI(), ArgWithoutCmd);
        if(cmdName.equals("createuser")) {
            String[] argForCreateUser = new String[ArgWithoutCmd.length + 1];
            argForCreateUser[0] = author;
            System.arraycopy(ArgWithoutCmd, 0, argForCreateUser, 1, ArgWithoutCmd.length);
            commandProtocol = new CommandProtocol(null, new CommandParser(), new YahooFinanceStockAPI(), ArgWithoutCmd);
        }
        Command cmd = commandManager.generate(commandManager.find(cmdName), commandProtocol);
        if (cmd == null) return("No such command. Try again.");
        boolean res = cmd.execute();
        if (! res) return cmd.help();
        return("command successfully executed!");
    }

    @Override
    public void input(String s) {

    }

    @Override
    public void output(String s) {

    }
}
