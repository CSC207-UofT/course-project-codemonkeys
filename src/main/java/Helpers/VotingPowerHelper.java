package Helpers;

public class VotingPowerHelper {

    // This method performs a non-linear bounded transformation for the positive number amount
    public static double fromAmount(double amount) {
        // TODO: find the pi constant
        return Math.atan(amount) * 2 / 3.14;
    }

    // This method takes a previous voting power sum and information about the current vote,
    // to calculate the voting power sum after considering this vote.
    public static double calcVote(double prev, double power, boolean isUpVote) {
        if(isUpVote) return prev + power;
        else return prev - power;
    }

    // This method takes the current voting power and amount of person participating to make a decision.
    // Returns a positive number when it decides to carry the transaction immediately.
    // Returns exactly zero whenit decides to do nothing but wait.
    // Returns a negative number when it decides to deny the transaction immediately.
    // If the force parameter is present and true, the method will not return 0 and make a decision immediately.
    public static int decide(double power, int count) {
        return VotingPowerHelper.decide(power, count, false);
    }
    public static int decide(double power, int count, boolean force) {
        if(power < 0.2 && count > 8) return -1;
        if(power > 0.7 && count > 2) return  1;
        if(!force) return 0;
        if(power > 0.4) return 1;
        else return -1;
    }

}
