package Presenters;

import UseCase.DataAccessInterfaceRelay;
import UseCase.GUIDataFetcher.TextFetcher;

import javax.swing.*;
import java.awt.*;


// Generate a Jpanel containing a text summary of the current status of the communal portfolio

class TextPanel implements Panel {
    DataAccessInterfaceRelay api;

    public TextPanel(DataAccessInterfaceRelay api) {
        this.api = api;
    }

    public JPanel getPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(TextFetcher.getData(api));
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        label.setForeground(Color.black);
        panel.add(label);
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.white);
        return panel;
    }
}
