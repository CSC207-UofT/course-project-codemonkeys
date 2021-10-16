package Controller;

import Entities.Vote;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VoteManager {
    private Map<UUID, Vote> voteMap;

    private VoteManager() {
        this.voteMap = new HashMap<UUID, Vote>();
    }

    private static VoteManager instance = null;

    public static VoteManager getInstance() {
        if(VoteManager.instance == null) {
            VoteManager.instance = new VoteManager();
        }
        return VoteManager.instance;  // VoteManager only initiated for once
    }

    public void addVote(Vote u) {
        this.voteMap.put(u.getId(), u);
    }

    public void delVote(Vote u) {
        this.voteMap.remove(u.getId());
    }

    public void delVote(UUID id) {
        this.voteMap.remove(id);
    }

    public Collection<Vote> getAllVotes(){
        return this.voteMap.values();
    }

    public Vote getVote(UUID id){
        return this.voteMap.get(id);
    }
}
