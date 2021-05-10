/**
 * This class is used to display a JPanel with a background color, to
 * give user a preview of the color. It's used to bypass UI style.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.gui;

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
        g.drawRect(0,0,getWidth()-1,getHeight()-1); // -1 corrects a visual bug.
    }
}
