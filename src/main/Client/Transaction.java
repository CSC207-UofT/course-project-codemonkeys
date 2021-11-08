package Client;

import Identification.Identifiable;

public class Transaction extends Identifiable {
    //____________________ Variables ___________________________________________________________________________________
    private User user;

    //____________________ Constructors ________________________________________________________________________________

    public Transaction(User user){
        super(null);
        this.user = user;
    }

    //____________________ Getters and Setters__________________________________________________________________________

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}