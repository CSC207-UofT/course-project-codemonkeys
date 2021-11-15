package Interfaces.GraphicsPresenterDemo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

class UserLeaderboardChartPanel implements Graphable {
    public DefaultCategoryDataset getDataSeries() {
        String users = "Top Users";



        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        series.addValue( 1000 , "" , "Alice");
        series.addValue( 1000  , "", "Bob" );
        series.addValue( 1010  , "", "Charles" );

        return series;

    }

    public ChartPanel getChartPanel(int x, int y, int width, int height) {

        JFreeChart barChart = ChartFactory.createBarChart("User Leaderboard", "",
                "Voting Power", getDataSeries(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
