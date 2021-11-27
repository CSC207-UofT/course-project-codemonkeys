package Containers;

import Assets.Asset;
import Identification.Identifiable;
import Users.User;

import java.util.Date;

// An immutable decision for a transaction.
// A transaction has an initiator, buying and selling assets, and a timestamp.
// The buying and selling value should be equal.
public final class Transaction extends Identifiable {

    public final User initiator;
    public final Asset sell;
    public final Asset buy;
    public final Date date;
    private boolean sold;

    public Transaction(User initiator, Asset sell, Asset buy){
        super();
        this.initiator = initiator;
        this.sell = sell;
        this.buy = buy;
        this.date = new Date();
        this.sold = false;
    }

    /**
     * return the sold status
     * @return true iff it is sold
     */
    public boolean checkState(){
        return this.sold;
    }

    /**
     * Changed iff the transaction is sold
     */
    public void  sold(){
        this.sold = true;
    }
    // Check the validity of the transaction
    public boolean checkIsValid(){
        return this.sell.getValue() == this.buy.getValue();
    }
}
