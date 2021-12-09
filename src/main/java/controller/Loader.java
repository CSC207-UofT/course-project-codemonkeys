package controller;

import usecase.managers.AssetManager;
import usecase.managers.TransactionManager;
import usecase.managers.UserManager;
import usecase.managers.VoteManager;

// A loader class for loading various managers before doing anything
public class Loader{
    public static void load(){
        AssetManager.load();
        TransactionManager.load();
        VoteManager.load();
        UserManager.load();
    }
}
