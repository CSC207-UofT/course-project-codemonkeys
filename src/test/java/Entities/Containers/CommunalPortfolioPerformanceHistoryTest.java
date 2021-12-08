package Entities.Containers;

import Entities.Containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
