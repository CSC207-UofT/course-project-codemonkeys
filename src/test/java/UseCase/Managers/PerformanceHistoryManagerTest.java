package UseCase.Managers;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import Interfaces.YahooFinanceStockAPI;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceHistoryManagerTest {
    DataAccessInterface api = new YahooFinanceStockAPI();

    @Test
    public void testUpdateTotalDeposit(){
        PerformanceHistoryManager.updateTotalDeposit(10);
        assertEquals(10, CommunalPortfolioPerformanceHistory.getInstance().getTotalDeposit());
        CommunalPortfolioPerformanceHistory.getInstance().setTotalDeposit(0);
    }

    @Test
    public void testHistory(){
        PerformanceHistoryManager.recordHistory(api);
        assertEquals(1,  PerformanceHistoryManager.getPortfolioHistory().size());
        assertEquals(1 , PerformanceHistoryManager.getAssetHistory().size());
        PerformanceHistoryManager.getAssetHistory().clear();
        assertEquals(0 , PerformanceHistoryManager.getAssetHistory().size());
        PerformanceHistoryManager.getPortfolioHistory().clear();
        assertEquals(0,  PerformanceHistoryManager.getPortfolioHistory().size());
    }
}
