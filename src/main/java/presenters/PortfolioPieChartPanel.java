package presenters;


import usecase.DataAccessInterfaceRelay;
import usecase.GUIDataFetcher.PortfolioPieChartFetcher;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.text.DecimalFormat;


class PortfolioPieChartPanel {
    // Generate a pie chart showing the portfolio composition

    //____________________ Variables ___________________________________________________________________________________
    private final DataAccessInterfaceRelay api;


    //____________________ Constructors ________________________________________________________________________________
    public PortfolioPieChartPanel(DataAccessInterfaceRelay api){
        this.api = api;
    }


    public ChartPanel getPanel(int x, int y, int width, int height) {

        PieDataset dataset = PortfolioPieChartFetcher.getData(api);
        JFreeChart pieChart = ChartFactory.createPieChart("Portfolio Composition", dataset);
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
