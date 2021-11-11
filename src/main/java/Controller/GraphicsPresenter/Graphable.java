package Controller.GraphicsPresenter;

import org.jfree.chart.ChartPanel;

interface Graphable {
    Object getDataSeries();

    ChartPanel getChartPanel(int x, int y, int width, int height);
}
