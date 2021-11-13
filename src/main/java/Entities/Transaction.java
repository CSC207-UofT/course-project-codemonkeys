package Entities;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private final User initializer;
    private final Date time;
    private final Asset from_asset;
    private final Asset to_asset;

    public Transaction(UUID id, String from, User initializer, String to,
                        Asset from_asset, Asset to_asset, Date time){
        this.id = id;
        this.from_asset = from_asset;
        this.to_asset = to_asset;
        this.initializer = initializer;
        this.time = time;
    }


    public UUID getId() {
        return this.id;
    }

    public Asset getFrom_asset() {
        return from_asset;
    }

    public Asset getTo_asset() {
        return to_asset;
    }

    public User getInitializer(){return this.initializer;}

    public Date getTime(){
        return this.time;
    }

}
