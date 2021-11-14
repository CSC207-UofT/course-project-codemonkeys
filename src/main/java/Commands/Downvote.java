package Commands;
import Containers.Vote;
import Managers.VoteManager;

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
    public boolean execute(ArrayList args) {
        VoteManager um = VoteManager.getInstance(); //get the UserManager

        for(Object o : args){ //loop through the arguments
            if (!(o instanceof Downvote)){ //if not create before
                um.downUser((User) o);
            }
            else {return false;
            }
        }
        return true;
    }

    @Override
    public String help() {
        return "this is info for the downvote command";
    }
}