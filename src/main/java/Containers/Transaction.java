package Containers;

import Assets.Asset;
import Identification.Identifiable;
import Users.User;

import java.util.Date;

public class Transaction extends Identifiable {

    private final User initiator;
    private final Asset in;
    private final Asset out;
    private final Date date;

    public Transaction(User initiator, Asset in, Asset out){
        super(null);
        this.initiator = initiator;
        this.in = in;
        this.out = out;
        this.date = new Date();
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
