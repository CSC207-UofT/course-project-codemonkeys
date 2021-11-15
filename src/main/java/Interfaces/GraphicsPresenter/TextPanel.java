package Interfaces.GraphicsPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

// Generate a Jpanel containing a text summary of the current status of the communal portfolio

public class TextPanel implements Panel{
    public String getData() {
        Date date = new Date();
        // Return the text displayed on the panel
        // TODO Connect with lower levels to get actual data

        return
                """
                <html> <br/>
                
                US $50000 Total Investment<br/>
                                
                Current Portfolio Net Worth: US <$60000<br/>
                                
                Current Net Profit: US $10000 (+20%)<br/>
                
                Total Invested Users: 3<br/>
                
                <br/>
                
                <html>
                """ + "Timestamp: " + date.toString();
    }

    public JPanel getPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel( getData());
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        label.setForeground(Color.black);
        panel.add(label);
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.white);
        return panel;
    }
}
