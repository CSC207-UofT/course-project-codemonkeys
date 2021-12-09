package entities.containers;

import entities.containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunalPortfolioPerformanceHistoryTest {
    private static final CommunalPortfolioPerformanceHistory cp = CommunalPortfolioPerformanceHistory.getInstance();

    @Test
    public void TestRecordHistory(){
        assertEquals(0, cp.getHistory().size());
        cp.recordHistory(1.0);
        assertEquals(1, cp.getHistory().size());
    }

    @Test
    public void TestDeposit(){
        assertEquals(0, cp.getTotalDeposit());
        cp.setTotalDeposit(100);
        assertEquals(100, cp.getTotalDeposit());
        cp.setTotalDeposit(0);
    }
}
