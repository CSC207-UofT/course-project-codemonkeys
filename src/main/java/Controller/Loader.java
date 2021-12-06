package Controller;

import UseCase.Managers.AssetManager;
import UseCase.Managers.TransactionManager;
import UseCase.Managers.UserManager;
import UseCase.Managers.VoteManager;

public class Loader{
    public static void load(){
        AssetManager.load();
        TransactionManager.load();
        VoteManager.load();
        UserManager.load();
    }
}
