package UseCases.Commands;

public class Upvote implements Command{

    public Upvote() {
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
