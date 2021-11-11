package UseCases.Commands;

public class Downvote implements Command{

    public Downvote() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the downvote command";
    }
}
