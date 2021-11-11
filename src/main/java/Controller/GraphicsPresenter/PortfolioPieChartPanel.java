package Controller.GraphicsPresenter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeriesCollection;

class PortfolioPieChartPanel implements Graphable {
    public PieDataset getDataSeries() {
        DefaultPieDataset series = new DefaultPieDataset( );
        series.setValue( "TSLA" , 2000 );
        series.setValue( "GOOG" , 3150  );
        series.setValue( "MSFT" , 400 );
        series.setValue( "AAPL" , 1000 );
        return series;
    }

    public ChartPanel getChartPanel(int x, int y, int width, int height) {
        JFreeChart lineChart = ChartFactory.createPieChart("Portfolio Compsition", getDataSeries());
        ChartPanel cp = new ChartPanel(lineChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }

}
