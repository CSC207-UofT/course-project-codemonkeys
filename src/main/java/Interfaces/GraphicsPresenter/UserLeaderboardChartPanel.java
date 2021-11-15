package Interfaces.GraphicsPresenter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

class UserLeaderboardChartPanel implements Panel {
    public DefaultCategoryDataset getData() {
        String users = "Top Users";



        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        series.addValue( 1000 , "" , "Alice");
        series.addValue( 1000  , "", "Bob" );
        series.addValue( 1010  , "", "Charles" );

        return series;

    }

    public ChartPanel getPanel(int x, int y, int width, int height) {

        JFreeChart barChart = ChartFactory.createBarChart("User Leaderboard", "",
                "Voting Power", getData(), PlotOrientation.VERTICAL, true, true, false);
        barChart.removeLegend();

        // Render chart styles
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());

        // Add data label
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);

        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }
}
