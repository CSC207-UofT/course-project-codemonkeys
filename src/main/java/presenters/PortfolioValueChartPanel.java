package presenters;

import usecase.DataAccessInterfaceRelay;
import usecase.GUIDataFetcher.PortfolioValueChartFetcher;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

class PortfolioValueChartPanel implements Panel {
// Create a ChartPanel displaying the value of the portfolio over time.

    DataAccessInterfaceRelay api;

    public PortfolioValueChartPanel(DataAccessInterfaceRelay api) {
        this.api = api;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {
        var dataset = new XYSeriesCollection();
        dataset.addSeries(PortfolioValueChartFetcher.getData(api));
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
