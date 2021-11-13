package UseCases;
import Entities.*;

import java.util.UUID;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactionLists;

    private TransactionManager(){ this.transactionLists = new ArrayList<>(); }

    public void creat(Date date, User user, double volume1, double price1, AssetType type1,
                      double volume2, double price2, AssetType type2){
        //create 2 assets then add into transaction
        Asset asset1 = new Asset(volume1, price1, type1);
        Asset asset2 = new Asset(volume2, price2, type2);
        // assign Id to the transaction.
        UUID id = UUID.randomUUID();
        // create transaction and add into the manager list
        this.transactionLists.add(new Transaction(id, date, user, asset1, asset2));
    }

    public List<Transaction> view(){
        return this.transactionLists;
    }

    public boolean checkTransaction(Transaction t){
        return this.transactionLists.contains(t);
    }

    public void delete(Transaction trans){this.transactionLists.remove(trans.getId());}

    public void delete(UUID id){this.transactionLists.remove(id);}



}
