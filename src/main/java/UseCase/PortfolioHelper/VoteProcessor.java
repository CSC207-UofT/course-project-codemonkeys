package UseCase.PortfolioHelper;
import Entities.Containers.Processor;
import Entities.Containers.Vote;

import java.util.ArrayList;
import java.util.List;

public class VoteProcessor extends Processor {
    // votingHistory: a history of votes in the portfolio
    private final List<Vote> votingHistory;

    public VoteProcessor(){
        this.votingHistory = new ArrayList<>();
    }

    // Add a vote to the system.
    public void add(Vote vote) {
        if (vote != null) {
            this.votingHistory.add(vote);
        }
    }

    public void sub(Vote vote0) {
        if (this.votingHistory.contains(vote0)) {
            this.votingHistory.remove(vote0);
        }
        else{
            System.out.println("Current portfolio does not contain " + vote0);
        }
    }

    public List<Vote> getVotingHistory() {
        return votingHistory;
    }
}
