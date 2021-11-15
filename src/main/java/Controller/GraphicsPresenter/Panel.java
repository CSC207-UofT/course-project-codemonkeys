package Controller.GraphicsPresenter;

import org.jfree.chart.ChartPanel;

import javax.swing.*;

interface Panel {
    Object getData();
    // Get data from lower levels and return them in a format that can be charted/displayed.

    JPanel getPanel(int x, int y, int width, int height);
    // Return a JPanel ready for display on JFrame of the defined UI.
}
