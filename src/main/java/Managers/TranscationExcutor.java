package Managers;

import Assets.Asset;
import Containers.Portfolio;
import Containers.Transaction;

public class TranscationExcutor {

    //____________________ Methods _____________________________________________________________________________________

    /**
     *
     * Execute a transaction by change the initiator's assets that been stored in portfolio
     * @param transaction
     *
     */
    public void excute(Transaction transaction){

        Asset transin = transaction.getIn();
        Asset tranout = transaction.getOut();

        //get the portfolio of the transaction initiator.
        Portfolio userPortfolio = transaction.getInitiator().getPortfolio();

        // add the asset that the user bought
        userPortfolio.add(transin);
        // remove the asset that user sells
        userPortfolio.remove(tranout);
    }
}
