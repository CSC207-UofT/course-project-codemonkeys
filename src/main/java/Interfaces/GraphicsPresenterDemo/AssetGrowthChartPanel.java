package Interfaces.GraphicsPresenterDemo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

class AssetGrowthChartPanel implements Graphable {
    public DefaultCategoryDataset getDataSeries() {

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

    public ChartPanel getChartPanel(int x, int y, int width, int height) {
        JFreeChart barChart = ChartFactory.createBarChart("Asset Growth Chart", "Time Frame",
                "Growth", getDataSeries(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
