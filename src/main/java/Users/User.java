package Users;

import Containers.Portfolio;
import Identification.Identifiable;

public class User extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________

    private String name; // Name of the User
    private Portfolio portfolio; // The personal/shadow portfolio of the User
    private double votingPower = 1;
    private int authorityLevel;

    //____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for User
     * @param name is the name of the User
     */
    public User(String name) {
        super(null);
        this.name = name;
        this.portfolio = new Portfolio();
    }

    //____________________ Methods _____________________________________________________________________________________

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
