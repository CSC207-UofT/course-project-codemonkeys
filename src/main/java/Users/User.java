package Users;

import Containers.Portfolio;
import Containers.Transaction;
import Identification.Identifiable;

import java.util.LinkedList;
import java.util.Queue;

public class User extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________

    private String name; // Name of the User
    private Queue<Transaction> latestTransaction;
    private double votingPower = 1;
    private int authorityLevel;

//____________________ Constructors ________________________________________________________________________________

    /**
     * Basic constructor for User
     * @param name is the name of the User
     */
    public User(String name) {
        super();
        this.name = name;
        this.latestTransaction = new LinkedList<Transaction>();
    }

    //____________________ Methods _____________________________________________________________________________________

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

}
