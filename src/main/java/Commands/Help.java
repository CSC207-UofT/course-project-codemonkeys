package Commands;

import Users.User;

import java.util.ArrayList;

public class Help implements Command {

    public Help() {

    }

    public boolean execute(User user, String[] args){
//        CommandManager cm = CommandManager.getInstance();
//
//        for(Command c : cm.getTemplates()){
//            if(args == null || args.contains(c.getClass()))
//                System.out.println(c.help());
//        }
        return true;
    }

    @Override
    public String help() {
        return "this is info for the Help command";
    }

    @Override
    public String name() {
        return "help";
    }

}
