package Entities.Containers;

import Entities.Containers.PerformanceHistories.AssetPerformanceHistory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AssetPerformanceHistoryTest {
    private static final AssetPerformanceHistory ap = AssetPerformanceHistory.getInstance();

    @Test
    public void TestRecordHistory(){
        assertEquals(0, ap.getHistory().size());
        Map<String, Double> m = new HashMap<>();
        m.put("test", 1.0);
        ap.recordHistory(m);
        assertEquals(1, ap.getHistory().size());
        ap.getHistory().clear();
    }
}
