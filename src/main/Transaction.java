import Clients.User;

public class Transaction {
    //____________________ Variables ___________________________________________________________________________________
    private User user;

    //____________________ Constructors ________________________________________________________________________________

    public Transaction(User user){
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