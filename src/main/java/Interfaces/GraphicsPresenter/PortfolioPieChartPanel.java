package Interfaces.GraphicsPresenter;

import Assets.Asset;
import Containers.Portfolio;
import Assets.Asset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.util.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

class PortfolioPieChartPanel implements Panel {
    // Generate a pie chart showing the portfolio composition

    //____________________ Variables ___________________________________________________________________________________
    Portfolio portfolio;


    //____________________ Constructors ________________________________________________________________________________
    public PortfolioPieChartPanel(Portfolio portfolio){
        this.portfolio = portfolio;
    };

    public PieDataset getData() {
        DefaultPieDataset series = new DefaultPieDataset();

        List<Asset> assetList = portfolio.getAssetList();

        for (Asset asset: assetList) {
            String symbol = asset.getSymbol();
            double value = asset.getValue();
            series.setValue(symbol , value);
        }

//        DefaultPieDataset series = new DefaultPieDataset( );
//        series.setValue( "TSLA" , 2000 );
//        series.setValue( "GOOG" , 3150  );
//        series.setValue( "MSFT" , 400 );
//        series.setValue( "AAPL" , 1000 );
        return series;
    }

    public ChartPanel getPanel(int x, int y, int width, int height) {

        PieDataset dataset = getData();
        JFreeChart pieChart = ChartFactory.createPieChart("Portfolio Compsition", dataset);
        pieChart.removeLegend();

        // Plot customization
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setLabelShadowPaint(null);
        plot.setLabelBackgroundPaint(Color.WHITE);
        PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "{0}: ${1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        plot.setLabelGenerator(generator);

        // Calculate greyscale according to percentage
        double max = 0.0;
        for (int i = 0; i < dataset.getItemCount(); i++) {
            Number value = dataset.getValue(i);
            if ((Double) value > max) {
                max = (Double) value;
            }
        }
        for (int i = 0; i < dataset.getItemCount(); i++) {
                plot.setSectionPaint(dataset.getKey(i), new Color(
                        (float) (1-(double) (dataset.getValue(i)) / max),
                        (float) (1-(double) (dataset.getValue(i)) / max),
                        (float) (1-(double) (dataset.getValue(i)) / max)));
            }

        // Create chart panel
        ChartPanel cp = new ChartPanel(pieChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }

}
