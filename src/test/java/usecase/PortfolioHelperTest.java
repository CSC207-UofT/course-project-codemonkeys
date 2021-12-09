package usecase;
import entities.assets.DataAccessInterface;
import entities.containers.Transaction;
import entities.containers.Vote;
import interfaces.YahooFinanceStockAPI;
import usecase.portfolio.portfolioHelper.AssetProcessor;
import usecase.portfolio.portfolioHelper.ProfitabilityCalculator;
import usecase.portfolio.portfolioHelper.TransactionProcessor;
import usecase.portfolio.portfolioHelper.VoteProcessor;
import org.junit.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioHelperTest {
    AssetProcessor ap = new AssetProcessor();
    ProfitabilityCalculator pc = new ProfitabilityCalculator();
    TransactionProcessor tp = new TransactionProcessor();
    VoteProcessor vp = new VoteProcessor();
    DataAccessInterface api = new YahooFinanceStockAPI();

    @Test
    public void testAP(){
        assertNull(ap.get(UUID.randomUUID()));
        assertEquals(0, ap.getValue(api));
    }

    @Test
    public void testPC(){
        assertEquals(0, pc.getProfitability());
        pc.setProfitability(20);
        assertEquals(20, pc.calculate());
        assertEquals(20, pc.getProfitability());
    }

    @Test
    public void testTP(){
        Transaction t = new Transaction(null, null, null);
        tp.add(t);
        assertEquals(1, tp.getTransactionList().size());
        tp.sub(t);
        assertEquals(0, tp.getTransactionList().size());
    }

    @Test
    public void testVP(){
        Vote v = new Vote(null, true);
        vp.add(v);
        assertEquals(1, vp.getVotingHistory().size());
        vp.sub(v);
        assertEquals(0, vp.getVotingHistory().size());

    }

}
