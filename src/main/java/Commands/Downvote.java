package Commands;
import java.util.ArrayList;

public class Downvote implements Command{
    public Downvote() {
    }
    /**
     * Create new users
     * @param args list of users
     * @returns whether the execution was successful
     */

    @Override
    public boolean execute(ArrayList args) {return false;
    }

    @Override
    public String help() {
        return "this is info for the downvote command";
    }
}