package UseCase;
import Entities.Assets.DataAccessInterface;
import Entities.Containers.Transaction;
import Entities.Containers.Vote;
import Interfaces.YahooFinanceStockAPI;
import UseCase.PortfolioHelper.AssetProcessor;
import UseCase.PortfolioHelper.ProfitabilityCalculator;
import UseCase.PortfolioHelper.TransactionProcessor;
import UseCase.PortfolioHelper.VoteProcessor;
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
