package Interfaces.GraphicsPresenter;

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

class PortfolioGrowthChartPanel implements Panel {
    // Assemble the chart displaying growth rate of the portfolio at different time frames as a bar chart.
    public DefaultCategoryDataset getData() {
        // TODO Connect with lower levels to get actual data
        String portfolio = "Portfolio";

        String hour = "Hour";
        String day = "Day";
        String sincePurchase = "Since Transaction";

        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        series.addValue( -1.0 , hour , portfolio);
        series.addValue( 3.0  , day, portfolio );
        series.addValue( -5.0  , sincePurchase, portfolio );


        return series;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        JFreeChart barChart = ChartFactory.createBarChart("Portfolio Growth Chart", "Time Frame",
                "Growth", getData(), PlotOrientation.VERTICAL, true, true, false);

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
