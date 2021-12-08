package Presenters;

import javax.swing.*;

interface Panel {

    JPanel getPanel(int x, int y, int width, int height);
    // Return a JPanel ready for display on JFrame of the defined UI.
}
