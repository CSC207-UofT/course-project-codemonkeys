package Containers;

import Assets.Asset;
import Identification.Identifiable;
import Users.User;

import java.util.Date;

public class Transaction extends Identifiable {

    private final User initiator;
    private final Asset sell;
    private final Asset buy;
    private final Date date;

    public Transaction(User initiator, Asset sell, Asset buy){
        super(null);
        this.initiator = initiator;
        this.sell = sell;
        this.buy = buy;
        this.date = new Date();
    }

    public Asset getSell() {
        return sell;
    }

    public Asset getBuy() {
        return buy;
    }

    public User getInitiator() {
        return initiator;
    }
}
