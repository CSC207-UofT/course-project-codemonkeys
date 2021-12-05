package Interfaces.GraphicsPresenter;

import Entities.Assets.Asset;
import Entities.Assets.DataAccessInterface;
import Entities.Containers.Portfolio;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

class PortfolioPieChartPanel implements Panel {
    // Generate a pie chart showing the portfolio composition

    //____________________ Variables ___________________________________________________________________________________
    private final Portfolio portfolio;
    private final DataAccessInterface api;


    //____________________ Constructors ________________________________________________________________________________
    public PortfolioPieChartPanel(Portfolio portfolio, DataAccessInterface api){
        this.portfolio = portfolio;
        this.api = api;
    };

    public PieDataset getData() {
        DefaultPieDataset series = new DefaultPieDataset();

        List<Asset> assetList = portfolio.getAssetList();

        for (Asset asset: assetList) {
            String symbol = asset.getSymbol();
            asset.updatePrice(api);
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

        // Calculate greyscale according to percentage for accessibility concerns
        double max = 0.0;
        for (int i = 0; i <= dataset.getItemCount(); i++) {
            Number value = dataset.getValue(i);
            if (value != null && (Double) value > max) {
                max = (Double) value;
            }
        }

        Color newColor;

        for (int i = 0; i < dataset.getItemCount(); i++) {
            try {newColor = new Color(
                    (float) (1-(double) (dataset.getValue(i)) / max),
                    (float) (1-(double) (dataset.getValue(i)) / max),
                    (float) (1-(double) (dataset.getValue(i)) / max));}
            catch(Exception e) {
                newColor = Color.black;
            }
                plot.setSectionPaint(dataset.getKey(i), newColor);
            }

        // Create chart panel
        ChartPanel cp = new ChartPanel(pieChart);
        cp.setMouseWheelEnabled(true);
        cp.setBounds(x, y, width, height);
        return cp;
    }

}
