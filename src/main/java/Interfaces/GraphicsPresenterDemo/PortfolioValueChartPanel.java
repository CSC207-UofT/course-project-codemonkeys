package Interfaces.GraphicsPresenterDemo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

class PortfolioValueChartPanel implements Graphable{


    public XYSeries getDataSeries() {
        var series = new XYSeries("Portfolio Value");
        series.add(1, 1000.35);
        series.add(2, 1012.67);
        series.add(3, 1077.35);
        series.add(4, 1100.60);
        series.add(5, 1115.35);
        series.add(6, 999.35);
        series.add(7, 1110.35);
        series.add(8, 1300.35);
        return series;
    }

    public ChartPanel getChartPanel(int x, int y, int width, int height) {
        var dataset = new XYSeriesCollection();
        dataset.addSeries(getDataSeries());
        JFreeChart lineChart = ChartFactory.createXYLineChart("Portfolio Value", "Time (Days)", "US$", dataset);
        ChartPanel cp = new ChartPanel(lineChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);

        return cp;
    }
}
