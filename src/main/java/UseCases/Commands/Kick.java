package UseCases.Commands;

public class Kick implements Command{

    public Kick() {

    }

    @Override
    public boolean execute() {
        return false;
    }


    @Override
    public String help() {
        return "this is information for the Kick command";
    }
}
