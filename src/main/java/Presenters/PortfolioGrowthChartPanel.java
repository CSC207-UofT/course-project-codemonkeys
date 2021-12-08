package Presenters;

import Entities.Assets.DataAccessInterface;
import Entities.Containers.PerformanceHistories.CommunalPortfolioPerformanceHistory;
import UseCase.Managers.AssetManager;
import UseCase.Managers.PerformanceHistoryManager;
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
import java.util.TreeMap;

class PortfolioGrowthChartPanel implements Panel {
    // Assemble the chart displaying growth rate of the portfolio at different time frames as a bar chart.

    DataAccessInterface api;

    public PortfolioGrowthChartPanel(DataAccessInterface api) {
        this.api = api;
    }

    public DefaultCategoryDataset getData() {
        // TODO Connect with lower levels to get actual data
        String p = "Portfolio";


        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        TreeMap<Date, Object> history = PerformanceHistoryManager.getPortfolioHistory();

        int half = (int) Math.floor(history.size() / 2);

        double currentValue = AssetManager.getInstance().getValue(api);
        double totalInvestment = CommunalPortfolioPerformanceHistory.getInstance().getTotalDeposit();
        double fullTime = (Double) history.get(history.firstKey());
        double halfTime = (Double) history.values().toArray()[half];

        String fullTimeLabel = history.size() + " Hours";
        String halfTimeLabel = half + " Hours";
        String totalInvestmentLabel = "Total Investment";

        series.addValue( (currentValue - halfTime) / halfTime * 100, halfTimeLabel , p);
        series.addValue((currentValue - fullTime) / fullTime  * 100, fullTimeLabel, p);
        series.addValue( (currentValue - totalInvestment) / totalInvestment * 100, totalInvestmentLabel, p );

        return series;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        JFreeChart barChart = ChartFactory.createBarChart("Portfolio Growth Chart", "Time Frame",
                "% Growth", getData(), PlotOrientation.VERTICAL, true, true, false);

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
        renderer.setSeriesPaint(0, new Color(200, 200, 200));
        renderer.setSeriesPaint(1, new Color(150, 150, 150));
        renderer.setSeriesPaint(2, new Color(100, 100, 100));

        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);

        return cp;
    }
}
