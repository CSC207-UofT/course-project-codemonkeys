package Interfaces.GraphicsPresenter;

import Assets.Asset;
import Assets.Currency;
import Assets.DataAccessInterface;
import Containers.Portfolio;
import Managers.PerformanceHistoryManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

class AssetGrowthChartPanel implements Panel {
    // Asembles the chart panel for a bar chart representing the growth rate of each specific asset at different
    // time frames.

    Portfolio portfolio;
    DataAccessInterface api;

    public AssetGrowthChartPanel(Portfolio portfolio, DataAccessInterface api) {
        this.portfolio = portfolio;
        this.api = api;
    }

    public DefaultCategoryDataset getData() {
        // TODO Connect with lower levels to get actual data
//        String tesla = "TSLA";
//        String apple = "APPL";
//        String microsoft = "MSFT";
//        String google = "GOOG";
//
//        String hour = "Hour";
//        String day = "Day";
//        String sincePurchase = "Since Transaction";

        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        List<Asset> assetList = portfolio.getAssetList();

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

    public ChartPanel getPanel(int x, int y, int width, int height) {
        DefaultCategoryDataset dataSeries = getData();
        JFreeChart barChart = ChartFactory.createBarChart("Non-liquid Asset Growth Chart", "Since Purchase",
                "Growth", dataSeries , PlotOrientation.VERTICAL, true, true, false);

        // Render chart styles
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());

        // Render Data labels
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);

        // Set bar colors
//        renderer.setSeriesPaint(0, new Color(200, 200, 200));
//        renderer.setSeriesPaint(1, new Color(150, 150, 150));
//        renderer.setSeriesPaint(2, new Color(100, 100, 100));


        // Create chart panels
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
