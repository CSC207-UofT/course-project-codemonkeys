package UseCase.Managers;

import Entities.Assets.Asset;
import Entities.Containers.Transaction;
import Entities.Containers.Vote;
import Entities.Users.User;
import UseCase.Commands.ReadWriter;
import UseCase.Commands.TransactionReadWriter;
import UseCase.Commands.VoteReadWriter;

import java.io.IOException;
import java.util.*;

public class VoteManager {
    private final Map<Transaction, List<Vote>> voteMap;
    private static final ReadWriter<VoteManager> rw = new VoteReadWriter();

    //create an object of VoteManager
    private static VoteManager instance = new VoteManager();

    private VoteManager() {this.voteMap = new HashMap<>();}

    //Get the only object available
    public static VoteManager getInstance() {
        try{
            instance = rw.readFromFile("./voteManager.ser");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Read Vote Manager Error: " + e.getMessage());
        }
        return instance;
    }

    // serialize the current vote manager
    public void save() {
        try {
            rw.saveToFile("./voteManager.ser", this);
        }
        catch (IOException e){
            System.out.println("Save Vote Manager Error: " + e.getMessage());
        }
    }
    /**
     * add vote to a transaction
     * @param trans transaction is which the vote is voting for
     * @param vote the vote
     */
    public void addVote(Transaction trans, Vote vote){
        if (!this.voteMap.containsKey(trans)) {
            this.voteMap.put(trans, new ArrayList<>());
        }
        this.voteMap.get(trans).add(vote);
    }

    /**
     * creat and add vote to a transaction
     * @param trans transaction is which the vote is voting for
     * @param initiator the INITIATOR of the vote
     * @param decision the vote is an upvote or a down vote
     */
    public void addVote(Transaction trans, User initiator, Boolean decision){
        Vote vote = new Vote(initiator, decision);
        if (!this.voteMap.containsKey(trans)) {
            this.voteMap.put(trans, new ArrayList<>());
        }
        this.voteMap.get(trans).add(vote);
    }

    /**
     * @param vote a vote of a transaction
     * @return the transaction which the vote is voting for
     */
    public Transaction voteFor(Vote vote){
        for (Transaction trans: this.voteMap.keySet()){
            if (this.voteMap.get(trans).contains(vote)){
                return trans;
            }
        }
        return null;
    }

    /**
     * returns a list of votes for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the votes of the transaction
     */
    public List<Vote> getVotes(Transaction trans){
        return this.voteMap.get(trans);
    }

    /**
     * returns a list of voters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the voters of the transaction
     */
    public List<User> getVoters(Transaction trans) {
        List<User> voters = new ArrayList<>();
        for (Vote vote: this.voteMap.get(trans)){
            voters.add(vote.initiator);
        }
        return voters;
    }

    /**
     * return a list of UpVoters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the UpVoters of the transaction
     */
    public List<User> getUpVoters(Transaction trans) {
        List<User> voters = new ArrayList<>();
        for (Vote vote: this.voteMap.get(trans)){
            if (vote.isUpvote){
                voters.add(vote.initiator);
            }
        }
        return voters;
    }

    /**
     * return a list of DownVoters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the DownVoters of the transaction
     */
    public List<User> getDownVoters(Transaction trans) {
        List<User> voters = new ArrayList<>();
        for (Vote vote: this.voteMap.get(trans)){
            if (!vote.isUpvote){
                voters.add(vote.initiator);
            }
        }
        return voters;
    }

    /**
     * Returns number of Voters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the number of Voters in int
     */
    public int numVoters(Transaction trans){
        return this.numDownVoters(trans) + this.numUpVoters(trans);
    }

    /**
     * Returns number of upVoters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the number of upVoters in int
     */
    public int numUpVoters(Transaction trans){
        int result = 0;
        for (Vote vote: this.voteMap.get(trans)){
            if (vote.isUpvote) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * Returns number of downVoters for a given transaction
     * @param trans the transaction is the queried transaction
     * @return the number of downVoters in int
     */
    public int numDownVoters(Transaction trans){
        int result = 0;
        for (Vote vote: this.voteMap.get(trans)){
            if (!vote.isUpvote) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * Returns information in string format on votes for a given transaction
     * @param trans the transaction is the queried transaction
     * @return information
     */
    public String viewVote(Transaction trans){
        StringBuilder sb = new StringBuilder();
        int up = this.numUpVoters(trans);
        int down = this.numDownVoters(trans);
        Asset a = trans.buy;
        sb.append("transaction id: ").append(trans.id).append(", buy: ").append(a.getSymbol()).append(", sell:" +
                        " ").append(trans.sell.getSymbol()).append(", value: ").append(a.getValue()).append(", number of upVoters: ")
                .append(up).append(", number of downVoters: ").append(down);
        return sb.toString();
    }

    /**
     * Returns information in string format on votes for all transactions
     * @return information
     */
    public String viewVote(){
        StringBuilder sb = new StringBuilder();
        for (Transaction trans: this.voteMap.keySet()){
            int up = this.numUpVoters(trans);
            int down = this.numDownVoters(trans);
            Asset a = trans.buy;
            sb.append("transaction id: ").append(trans.id).append(", buy: ").append(a.getSymbol()).append(", sell:" +
                            " ").append(trans.sell.getSymbol())
                    .append(", value: ").append(a.getValue()).append(", number of upVoters: ")
                    .append(up).append(", number of downVoters: ").append(down).append(System.lineSeparator());
        }

        return sb.toString();
    }

    // for testing
    public void removeTrans(Transaction trans){
        this.voteMap.remove(trans);
    }
}
