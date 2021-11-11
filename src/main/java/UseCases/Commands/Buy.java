package UseCases.Commands;

public class Buy implements Command{

    public Buy() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the buy command";
    }
}
