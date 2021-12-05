package Interfaces.GraphicsPresenter;

import UseCase.Managers.PerformanceHistoryManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.Date;
import java.util.TreeMap;

class PortfolioValueChartPanel implements Panel {
// Create a ChartPanel displaying the value of the portfolio over time.

    public XYSeries getData() {
        // Format the data as needed by JFreeChart
        // TODO Connect with lower levels to get actual data

        var series = new XYSeries("Portfolio Value (US $)");

        TreeMap<Date, Object> history = PerformanceHistoryManager.getPortfolioHistory();

        Date timeNow = new Date();

        for (Date date : history.keySet()) {
            double diff = date.getTime() - timeNow.getTime();
            series.add(diff, (Double) history.get(date));
        }

        return series;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        var dataset = new XYSeriesCollection();
        dataset.addSeries(getData());
        JFreeChart lineChart = ChartFactory.createXYLineChart("Portfolio Value", "Time (Milliseconds from Timestamp)", "US$", dataset);
        lineChart.removeLegend();

        XYPlot plot = (XYPlot) lineChart.getPlot();
        plot.setBackgroundPaint(Color.white);

        XYLineAndShapeRenderer renderer =  (XYLineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesItemLabelsVisible(0,true);

        ChartPanel cp = new ChartPanel(lineChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);

        return cp;
    }
}
