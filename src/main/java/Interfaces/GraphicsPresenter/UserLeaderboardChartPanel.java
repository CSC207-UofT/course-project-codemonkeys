package Interfaces.GraphicsPresenter;

import Managers.UserManager;
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
import java.util.*;
import java.util.List;

class UserLeaderboardChartPanel implements Panel {


    public DefaultCategoryDataset getData() {
        /**
         * Prepares data for graphing.
         *
         * Iterate through all registered users, then calculate their voting power and sort the users by their voting
         * powers.
         */

        UserManager userManager = UserManager.getInstance();
        DefaultCategoryDataset series = new DefaultCategoryDataset( );

        TreeMap<Double, ArrayList<String>> votingPowerMap = new TreeMap<>();

        // sort users accroding to voting power

        for (UUID id : userManager.keySet()) {
            double votingPower = userManager.get(id).getVotingPower();
            String name = userManager.get(id).getName();

            if (!votingPowerMap.containsKey(votingPower)) {
                votingPowerMap.put(votingPower, new ArrayList<String>(List.of(name)));
            } else {
                votingPowerMap.get(votingPower).add(name);
            }
        }

        for (double votingPower : votingPowerMap.descendingKeySet()) {
            for (String name : votingPowerMap.get(votingPower)) {
                series.addValue(votingPower, "", name);
            }
        }

//        series.addValue( 1000 , "" , "Alice");
//        series.addValue( 1000  , "", "Bob" );
//        series.addValue( 1010  , "", "Charles" );

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
