package usecase.GUIDataFetcher;

import entities.assets.Asset;
import entities.assets.Currency;
import usecase.DataAccessInterfaceRelay;
import usecase.managers.AssetManager;

import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;

public class AssetGrowthChartFetcher {

    /**
     * Fetches and packages data from backend for presentation on JPanels.
     *
     * Author: Andrew Zhang
     * Version: 1.0
     */

    public static DefaultCategoryDataset getData(DataAccessInterfaceRelay api) {

        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        List<Asset> assetList = AssetManager.getInstance().getAssetList();

        for (Asset asset: assetList) {
            if (! (asset instanceof Currency)) {
                String symbol = asset.getSymbol();
                asset.updatePrice(api);
                double currentPrice = asset.getPrice();
                double initialPrice = asset.getInitialPrice();
                double growthRate = (currentPrice - initialPrice) / initialPrice;
                series.addValue(growthRate * 100, "", symbol);
            }
        }

        return series;
    }

}
