package PatternishApp.gui;

import javax.swing.*;
import java.awt.*;

public class ColorSquare extends javax.swing.JPanel{
    private Color color;

    public ColorSquare(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0,0,getWidth()-1,getHeight()-1);
    }
}
