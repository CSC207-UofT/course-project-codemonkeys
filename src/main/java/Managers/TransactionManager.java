package Managers;
import Containers.Transaction;

import java.util.UUID;
import java.util.*;

/**
 * @Author: Raymond Zhang
 */

public class TransactionManager extends HashMap<UUID, Transaction>{
    private static TransactionManager instance;

    private TransactionManager() {
        super();
    }

    static {
        instance = new TransactionManager();
    }

    public static TransactionManager getInstance() {
        return instance;
    }
}