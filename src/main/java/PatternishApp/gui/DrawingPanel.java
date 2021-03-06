/**
 * DrawingPanel is the class used to draw the shapes. It's used for the
 * base image, the full image and the exported image.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.gui;

import PatternishApp.domain.Drawer;
import PatternishApp.domain.ImageFlipping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawingPanel extends javax.swing.JPanel
{
    private MainWindow mainWindow;
    private ImageFlipping flipper;
    private panelType type;

    //Panel types
    enum panelType{
        BASE,
        FULL,
        EXPORT
    }

    public DrawingPanel(){
        initComponent();
    }

    public DrawingPanel(MainWindow mainWindow,panelType type){
        this.type = type;
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

            switch(type){
                case BASE:
                    mainDrawer.drawBaseImage(g);
                    break;
                case FULL:
                    mainDrawer.drawFullImage(g);
                    break;
                case EXPORT:
                    mainDrawer.drawExportImage(g);
                    break;
            }
        }

        else {
            g.drawString("Shape drawing will be here.",10,10);
        }

    }

    /*
     * This method is used to used to save current DrawingPanel as a png.
     */
    public void saveImage(String nom){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = image.createGraphics();
        paint(g2);
        try{
            ImageIO.write(image, "png", new File(nom + ".png"));
        }
        catch (Exception e){
            System.out.println("Can't export image.");
        }
    }

    public BufferedImage getImage(){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);

        return image;
    }
}
