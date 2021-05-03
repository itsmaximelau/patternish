package PatternishApp.domain;


import java.awt.*;

public class Drawer {
    private Controler controler;

    public Drawer(Controler controler){
        this.controler = controler;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for (Shape s : controler.getShapeList()){
            g2.setStroke(new BasicStroke(4));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(s.getX(),s.getY(),s.getSize());
            g2.setColor(Color.DARK_GRAY);
            g2.fillPolygon(s.getX(),s.getY(),s.getSize());
        }
    }
}
