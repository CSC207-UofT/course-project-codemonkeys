package UseCases.Commands;

public class ViewVote implements Command{

    public ViewVote() {
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String help() {
        return "this is info for the viewvote command";
    }
}
