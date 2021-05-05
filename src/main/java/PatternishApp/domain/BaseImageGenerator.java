package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BaseImageGenerator {
    private List<Shape> shapeList = new ArrayList<>();
    private int amount;
    private Controler controler;
    private DrawingPanel drawingPanelBase;

    public BaseImageGenerator(Controler c, DrawingPanel drawingPanelBase) {
        this.controler = c;
        this.amount = c.getShapeAmount();
        this.drawingPanelBase = drawingPanelBase;
    }

    public BufferedImage generateBaseImage() {
        setParameters();
        clearShapeList();
        for (int i = 0; i < amount; i++) {
            addShapeList(controler.getRandomShapeFactory().generateShape());
        }
        drawingPanelBase.repaint();
        return drawingPanelBase.getImage();
    }

    public void setParameters(){
        this.amount = controler.getShapeAmount();
    }

    public List<Shape> getShapeList(){
        return shapeList;
    }

    public void addShapeList(Shape s){
        shapeList.add(s);
    }

    public void clearShapeList(){
        this.shapeList.clear();
    }

}
