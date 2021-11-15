package Interfaces;
import Commands.CommandParser;
import Managers.UserManager;
import Users.Admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLine {
    private Scanner scan = new Scanner(System.in);
    private CommandParser parser = new CommandParser();

    public void start() {
        while(true) {
            System.out.print("Please enter root admin name: ");
            String root = this.scan.nextLine().trim();
            if(!root.isEmpty()) {
                UserManager.getInstance().addUser(new Admin(root));
                break;
            }
            System.out.println("Please enter a valid username.");
        }

        System.out.println("System start up, please enter command.");

        while(true) {
            System.out.print("> ");
            String raw = this.scan.nextLine();
            if (raw.equals("exit")) break;
            String[] input = raw.split(":");
            try {
                String cur_user = input[0].trim();
                String arguments = input[1].trim();
                boolean result = parser.parseCommand(cur_user, arguments);
                if(!result) throw new RuntimeException();
            }
            catch(Exception e) {
                e.printStackTrace();
                System.out.println("Fail to execute your command. Type again");
            }
        }
    }

}
