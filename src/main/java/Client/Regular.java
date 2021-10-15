package Client;

public class Regular extends User {
    double net = 0;
    public Regular(String name){
        super(name);
    }

    public void netChange(double amount) {
        this.net += amount;
    }

}
