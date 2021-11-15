package Helpers;

public class VotingPowerHelper {

    private VotingPowerHelper() {

    }

    // Convert from aggregate transaction amount to voting power index.
    public static double fromTransactionAmount(double amount) {
        return 0.0;
    }

    // Adds individual voter's voting power according to their vote
    public static double countVote(double prev, double votingPower, boolean isUpvote) {
        return prev;
    }

    public static int checkVote(double votingPower) {
        return VotingPowerHelper.checkVote(votingPower, false);
    }

    // Check the current voting power:
    // If currently we can accept this transaction, it will return something greater than 0.
    // If currently we cannot make a decision about this transaction, it will return exactly 0.
    // If currently we shall reject this transaction it will return something smaller than 0.
    // If forced is true, the method will immediately decide the next action and not return a 0.
    public static int checkVote(double votingPower, boolean force) {
        return 0;
    }

}
