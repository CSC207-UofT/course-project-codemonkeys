package UseCases.Commands;

public class Sell implements Command{

    public Sell() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the sell command";
    }
}
