package UseCases.Commands;

import java.util.ArrayList;

public class Help implements Command {

    public Help() {

    }

    public boolean execute(ArrayList args){
        CommandManager cm = CommandManager.getInstance();

        for(Command c : cm.getTemplates()){
            if(args == null || args.contains(c.getClass()))
                System.out.println(c.help());
        }
        return true;
    }

    @Override
    public String help() {
        return "this is info for the Help command";
    }

}
