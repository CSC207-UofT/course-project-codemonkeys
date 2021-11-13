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
    private boolean status; //True if it is on going and false if the vote is vetoed.

    public Vote(User init, String fromType, String toType, double val) {
        this.id = UUID.randomUUID();
        this.initiator = init;
        this.fromType = fromType;
        this.toType = toType;
        this.value = val;
        this.upVoters = new ArrayList<User>();
        this.downVoters = new ArrayList<User>();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isEligible(){
        return this.initiator.hasAssetValue(this.fromType, this.value);
    }

    public boolean check() {
        double sum = 0.0;
        for(User u : this.upVoters) {
            sum += u.getLiquidAssetValue();
        }
        for(User u : this.downVoters) {
            sum -= u.getLiquidAssetValue();
        }



        // --------------------
        changeMessage(sum >= this.value ? "True" : "False");




        return sum >= this.value;

    }

    public boolean checkApprove(int num) {
        if (num != this.upVoters.size() + this.downVoters.size()) {
            return false;
        } else {
            return this.check();
        }
    }

    public int upVoterSize() {
        return this.upVoters.size();
    }

    public int downVoterSize() {
        return this.downVoters.size();
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
        return this.id;
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
        if(to == null) {
            this.initiator.addAsset(this.fromType);
            to = this.initiator.getAsset(this.toType);
        }
        if(from == null) {
            this.initiator.addAsset(this.fromType);
            from = this.initiator.getAsset(this.fromType);
        }
        return Asset.transfer(from, to, this.value);
    }



    //-----------------------------------------------
    public void changeMessage(String message)
    {
       // setChanged();
       // notifyObservers(message);
    }
}