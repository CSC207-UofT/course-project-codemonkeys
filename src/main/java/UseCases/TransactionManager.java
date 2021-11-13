package UseCases;
import Entities.Transaction;
import Entities.Asset;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.naming.NamingSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TransactionManager {
    private Map<UUID, Transaction[]> transactionMap;

    private TransactionManager(){this.transactionMap = new HashMap<UUID, Transaction[]>(); }

    public boolean check(Transaction tran){

    }

    public void creat(String from, String to, double val){
        if(Transaction.check()){

        }
        Transaction[] trans = Transaction.generateTransactionPair(from, to, val);
        this.transactionMap.put(trans[0].getId(), trans);
    }

    public String viewTransaction(){
        StringBuilder res = new StringBuilder();
        for (Map.Entry<UUID, Transaction[]> entry : this.transactionMap.entrySet()) {
            UUID u = entry.getKey();
            Transaction v[] = entry.getValue();
            for (Transaction t: v) {
                res.append("id: ").append(u.toString()).append(", from ").append(t.getFrom_type()).
                        append(", to: ").append(t.getTo_type()).
                        append(", value: ").append(t.getValue());
            }
        }
        return res.toString();
    }

    public void delete(Transaction trans){this.transactionMap.remove(trans.getId());}

    public void delete(UUID id){this.transactionMap.remove(id);}

    public Transaction[] getTransaction(UUID id){return this.transactionMap.get(id); }

}
