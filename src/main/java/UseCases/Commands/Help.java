package UseCases.Commands;

public class Help implements Command {

    public Help() {

    }

    public boolean execute(){
        CommandManager cm = CommandManager.getInstance();
        for(Command c : cm.getTemplates()){
            System.out.println(c.help());
        }
        return true;
    }

    @Override
    public String help() {
        return "this is info for the Help command";
    }

}
