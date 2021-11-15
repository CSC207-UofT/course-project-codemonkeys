package Managers;

import Containers.Portfolio;

import javax.sound.sampled.Port;
import java.net.http.WebSocket;
import java.util.*;

public class PortfolioHistoryManager extends HashMap<Portfolio, Queue<Double>> {
    private static PortfolioHistoryManager instance;
    private Double latestSnapshot;

    private PortfolioHistoryManager(){
        super();
    }

    static {
        instance = new PortfolioHistoryManager();
    }

    public static PortfolioHistoryManager getInstance() {
        return instance;
    }

    public void snapshot(Portfolio portfolio){
        double value = portfolio.getTotalValue();

        if(!this.containsKey(portfolio)){
            Queue<Double> netQueue = new LinkedList<>();
            this.put(portfolio, netQueue);
        }

        Queue<Double> theQueue = this.get(portfolio);

        if (theQueue.size() > 600)
            theQueue.remove();
        theQueue.add(value);

        latestSnapshot = value;
    }


    public double getNetPast25(Portfolio portfolio){
        return latestSnapshot - this.get(portfolio).peek();
    }



}