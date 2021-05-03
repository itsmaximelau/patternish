package PatternishApp.gui;

import PatternishApp.domain.Drawer;
import java.awt.Graphics;

public class DrawingPanel extends javax.swing.JPanel
{
    private MainWindow mainWindow;

    public DrawingPanel(){
        initComponent();
    }

    public DrawingPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        setVisible(true);
        initComponent();
    }

    private void initComponent() {
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (this.mainWindow != null){
            super.paintComponent(g);
            Drawer mainDrawer = new Drawer(mainWindow.controler);
            mainDrawer.draw(g);
        }

        else {
            g.drawString("Shape drawing will be here.",10,10);
        }

    }

    public void regen(){
        repaint();
    }

    public void setMainWindow(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }
}
