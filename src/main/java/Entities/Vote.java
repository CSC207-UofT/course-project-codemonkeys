package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vote{
    private UUID id;
    private User initiator;
    private String fromType;
    private String toType;
    private double value;
    private List<User> upVoters;
    private List<User> downVoters;

    public Vote(User init, String fromType, String toType, double val) {
        this.id = UUID.randomUUID();
        this.initiator = init;
        this.fromType = fromType;
        this.toType = toType;
        this.value = val;
        this.upVoters = new ArrayList<User>();
        this.downVoters = new ArrayList<User>();
    }

    public boolean isEligible(){
        return this.initiator.hasAssetValue(this.fromType, this.value);
    }

    public boolean check() {
        double sum = this.initiator.getLiquidAssetValue();
        for(User u : this.upVoters) {
            sum += u.getLiquidAssetValue();
        }
        for(User u : this.downVoters) {
            sum -= u.getLiquidAssetValue();
        }
        return sum >= this.value;
    }

    public void upVote(User u) {
        this.upVoters.add(u);
    }

    public void downVote(User u) {
        this.downVoters.add(u);
    }

    public List<User> getUpVoters() {
        List<User> res = new ArrayList<User>();
        for (User u: this.upVoters) {
            res.add(u);
        }
        return res;
    }

    public List<User> getDownVoters() {
        List<User> res = new ArrayList<User>();
        for (User u: this.downVoters) {
            res.add(u);
        }
        return res;
    }

    public UUID getId() {
        return id;
    }

    public User getInitiator() {
        return initiator;
    }

    public String getFromType() {
        return fromType;
    }

    public String getToType() {
        return toType;
    }

    public double getValue() {
        return value;
    }

    public boolean performTransfer() {
        Asset from = this.initiator.getAsset(this.fromType);
        Asset to = this.initiator.getAsset(this.toType);
        return Asset.transfer(from, to, this.value);
    }
}

