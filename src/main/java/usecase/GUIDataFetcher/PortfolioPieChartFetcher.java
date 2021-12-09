package usecase.GUIDataFetcher;

import entities.assets.Asset;
import usecase.DataAccessInterfaceRelay;
import usecase.managers.AssetManager;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.List;

public class PortfolioPieChartFetcher {
    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */

    public static PieDataset getData(DataAccessInterfaceRelay api) {
        DefaultPieDataset series = new DefaultPieDataset();

        List<Asset> assetList = AssetManager.getInstance().getAssetList();

        for (Asset asset: assetList) {
            String symbol = asset.getSymbol();
            asset.updatePrice(api);
            double value = asset.getValue();
            series.setValue(symbol , value);
        }
        return series;
    }
}
