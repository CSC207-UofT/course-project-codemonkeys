public class Vote {
    //____________________ Variables ___________________________________________________________________________________

    private String voter;
    private double power;

    //____________________ Constructors ________________________________________________________________________________

    public Vote(String voter, double power) {
        this.voter = voter;
        this.power = power;
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
}