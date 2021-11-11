package Controller.GraphicsPresenter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

class PortfolioGrowthChartPanel implements Graphable {
    public DefaultCategoryDataset getDataSeries() {

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

    public ChartPanel getChartPanel(int x, int y, int width, int height) {
        JFreeChart barChart = ChartFactory.createBarChart("Portfolio Growth Chart", "Time Frame",
                "Growth", getDataSeries(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
