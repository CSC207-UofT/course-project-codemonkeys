package UseCases.Commands;

public class CheckPrice implements Command{

    public CheckPrice() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the upvote command";
    }
}
