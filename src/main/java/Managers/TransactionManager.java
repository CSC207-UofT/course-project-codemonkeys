package Managers;

import Containers.Portfolio;
import Containers.Transaction;
import Helpers.VotingPowerHelper;
import Users.User;

import java.util.*;

// TransactionManager is a manager and data storage class for managing transaction history.
// It can also calculate voting power from transaction history.
public class TransactionManager {

    private static final int HISTORY_LENGTH = 25;
    private static TransactionManager instance;

    static {
        TransactionManager.instance = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return TransactionManager.instance;
    }

    // The UUID of user and the transaction history of user
    private HashMap<UUID, Queue<Transaction>> storage;

    private TransactionManager() {
        this.storage = new LinkedHashMap<UUID, Queue<Transaction>>();
    }

    // The transaction is immediately performed by subtracting and adding assets in the common protfolio.
    // If there's not enough asset to sell, this method will return false.
    // If the operation is successfully performed, this method will return true.
    // Node: this method will not complain about unbalanced transactions.
    public boolean performTransaction(Transaction transaction) {
        // Verify balance
        Portfolio common = Portfolio.getInstance();
        double availableValue = common.getValue(transaction.sell.getType());
        if (availableValue < transaction.buy.getValue()) return false;
        // Perform transaction
        common.sub(transaction.sell);
        common.add(transaction.buy);
        // Record transaction history
        Queue<Transaction> history = this.storage.get(transaction.initiator.id);
        if (history == null) {
            history = new LinkedList<Transaction>();
            this.storage.put(transaction.initiator.id, history);
        }
        history.add(transaction);
        while (history.size() > TransactionManager.HISTORY_LENGTH) history.remove();
        return true;
    }

    private double getTransactionAmount(User user) {
        Queue<Transaction> history = this.storage.get(user.id);
        if(history == null) return Double.NaN;
        double value = 0;
        for(Transaction transaction : history) {
            // TODO: buy value must equal sell value
            value += transaction.buy.getValue();
        }
        return value;
    }

    // This method calculates the voting power of a specific user.
    // It applies a non-linear shaping to the user's latest aggregate transaction value.
    // If the user has no history the method will return NaN.
    public double getVotingPower(User user) {
        double value = this.getTransactionAmount(user);
        if(value == Double.NaN) return Double.NaN;
        return VotingPowerHelper.fromAmount(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Transaction Manager Debug Report: \n");
        for(UUID key : this.storage.keySet()) {
            User user = UserManager.getInstance().getUser(key);
            sb.append(key.toString()).append(" - ");
            sb.append(user.getName()).append(": ");
            sb.append(this.getVotingPower(user)).append(" ($");
            sb.append(this.getTransactionAmount(user)).append(")\n");
            Queue<Transaction> history = this.storage.get(key);
            for(Transaction transaction : history) {
                sb.append("    ");
                sb.append(transaction.id.toString()).append(": ");
                sb.append(transaction.sell.getType()).append('[');
                sb.append(transaction.sell.getVolume()).append(" x $");
                sb.append(transaction.sell.getPrice()).append(" (= $");
                sb.append(transaction.sell.getValue()).append(")] -> ");
                sb.append(transaction.buy.getType()).append('[');
                sb.append(transaction.buy.getVolume()).append(" x $");
                sb.append(transaction.buy.getPrice()).append(" (= $");
                sb.append(transaction.buy.getValue()).append(")]\n");
            }
        }
        if(this.storage.keySet().size() == 0)
            sb.append("Nothing in history. \n");
        return sb.toString();
    }

}

// All tests passed
