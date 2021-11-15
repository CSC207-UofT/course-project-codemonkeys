package Users;

import Containers.Portfolio;
import Containers.Transaction;
import Identification.Identifiable;

import java.util.LinkedList;
import java.util.Queue;

public class User extends Identifiable {

    //____________________ Variables ___________________________________________________________________________________

    private String name; // Name of the User

    public User(String name) {
        super();
        this.name = name;
    }

    //____________________ Methods _____________________________________________________________________________________

    public String getName() {
        return name;
    }

}
