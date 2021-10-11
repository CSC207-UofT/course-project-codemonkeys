public class Vote {
    //____________________ Variables ___________________________________________________________________________________

    private String voter;
    private double power;
    private String vote_for;

    //____________________ Constructors ________________________________________________________________________________

    public Vote(String voter, double power, String vote_for) {
        this.voter = voter;
        this.power = power;
        this.vote_for = vote_for

    }

    //____________________ Getters and Setters__________________________________________________________________________

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getVote_for() {return vote_for}

    public void setVote_for(String vote_for) {this.vote_for = vote_for;}
}