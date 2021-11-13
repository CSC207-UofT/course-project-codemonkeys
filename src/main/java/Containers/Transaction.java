package Containers;

import Assets.Asset;
import Identification.Identifiable;
import Users.User;

public class Transaction extends Identifiable {

    private final User initiator;
    private final Asset in;
    private final Asset out;

    public Transaction(User initiator, Asset in, Asset out){
        super(null);
        this.initiator = initiator;
        this.in = in;
        this.out = out;
    }

    public Asset getIn() {
        return in;
    }

    public Asset getOut() {
        return out;
    }

    public User getInitiator() {
        return initiator;
    }
}
