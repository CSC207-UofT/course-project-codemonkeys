package Presenters;

import UseCase.DataAccessInterfaceRelay;
import UseCase.GUIDataFetcher.AssetGrowthChartFetcher;

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

class AssetGrowthChartPanel implements Panel {
    // Assembles the chart panel for a bar chart representing the growth rate of each specific asset at different
    // time frames.

    DataAccessInterfaceRelay api;

    public AssetGrowthChartPanel(DataAccessInterfaceRelay api) {
        this.api = api;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        DefaultCategoryDataset dataSeries = AssetGrowthChartFetcher.getData(api);
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


        // Create chart panels
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
