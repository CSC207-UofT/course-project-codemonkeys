package Interfaces;
import Commands.CommandParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLine {
    private Scanner scan = new Scanner(System.in);
    private CommandParser parser = new CommandParser();
    private boolean adminPresent = false;

    public boolean getCommand() {
        if (! adminPresent) System.out.println("Please Enter Admin Name and deposit money");
        String raw = this.scan.nextLine();
        if (raw.equals("exit")) return false;
        String[] input = raw.split(":");
        String cur_user = input[0];
        String arguments = input[1];
        boolean result = parser.parseCommand(cur_user, arguments);
        if (! result) System.out.println("Fail to execute your command. Type again");
        return true;
    }

}
