package Users;

import Containers.Portfolio;
import Identification.Identifiable;

/**
 * @Author: Vim
 */
public class User extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________

    private String name; // Name of the User
    private Portfolio portfolio; // The personal/shadow portfolio of the User
    private double votingPower;
    private int securityLevel; // if the user is banned or not

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for User
     *
     * @param name is the name of the User
     */
    public User(String name) {
        this.name = name;
        this.portfolio = new Portfolio();
        this.votingPower = 1.0;
        this.securityLevel = 1;
    }

    //____________________ Methods _____________________________________________________________________________________

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortfolio(Portfolio portfolio) {

    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setVotingPower(double num) {

    }
    public double getVotingPower() {
        return 0;
    }


}
