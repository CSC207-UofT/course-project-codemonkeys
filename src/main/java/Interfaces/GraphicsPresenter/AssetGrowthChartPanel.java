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

class AssetGrowthChartPanel implements Panel {
    // Asembles the chart panel for a bar chart representing the growth rate of each specific asset at different
    // time frames.

    public DefaultCategoryDataset getData() {
        // TODO Connect with lower levels to get actual data
        String tesla = "TSLA";
        String apple = "APPL";
        String microsoft = "MSFT";
        String google = "GOOG";

        String hour = "Hour";
        String day = "Day";
        String sincePurchase = "Since Transaction";

        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        series.addValue( -1.0 , hour , tesla);
        series.addValue( 3.0  , day, tesla );
        series.addValue( -5.0  , sincePurchase, tesla );

        series.addValue( 5.0  , hour, microsoft );
        series.addValue( -6.0 , day, microsoft );
        series.addValue( 10.0 , sincePurchase, microsoft );

        series.addValue( 4.0 , hour , apple );
        series.addValue( 2.0 , day, apple  );
        series.addValue( -3.0 , sincePurchase, apple  );

        series.addValue( 4.0 , hour , google );
        series.addValue( -2.0 , day, google  );
        series.addValue( 3.0 , sincePurchase, google );

        return series;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        DefaultCategoryDataset dataSeries = getData();
        JFreeChart barChart = ChartFactory.createBarChart("Asset Growth Chart", "Time Frame",
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
        renderer.setSeriesPaint(0, new Color(200, 200, 200));
        renderer.setSeriesPaint(1, new Color(150, 150, 150));
        renderer.setSeriesPaint(2, new Color(100, 100, 100));

        // Create chart panels
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
