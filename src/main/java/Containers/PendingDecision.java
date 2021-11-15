package Containers;

import Identification.Identifiable;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

// An immutable container for a pending decision.
// A pending decision is a set of votes associated with a transaction that hasn't been carried out.
// A pending decision's identifier is its associated transaction's identifier.
public final class PendingDecision extends Identifiable {

    public final Transaction transaction;
    public final List<Vote> votes;
//  public final Date expiresOn;

    public PendingDecision(Transaction transaction) {
        super(transaction);
        this.transaction = transaction;
        this.votes = new ArrayList<Vote>();
    }

}
