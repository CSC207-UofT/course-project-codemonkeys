package Managers;

import Users.User;

public class VotingPowerCalculator {

    public static double calculateVotingPower(User user){
        double net = PortfolioHistoryManager.getInstance().getNetPast25(user.getPortfolio());
        return Math.tan(net/100) + Math.PI/2;
    }


}
