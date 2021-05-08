package PatternishApp.domain;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer {
    private Controler controler;

    public Drawer(Controler controler){
        this.controler = controler;
    }

    public void drawBaseImage(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (Shape s : controler.getImageFactory().getShapeList()){
            g2.setStroke(new BasicStroke(4));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(s.getX(),s.getY(),s.getSize());
            g2.setColor(Color.DARK_GRAY);
            g2.fillPolygon(s.getX(),s.getY(),s.getSize());
        }
    }

    public void drawFullImage(Graphics g){
        g.drawImage(controler.getFullImage(),0,0,null);
    }

    public void drawExportImage(Graphics g){
        g.drawImage(controler.getExportImage(),0,0,null);
    }
}
