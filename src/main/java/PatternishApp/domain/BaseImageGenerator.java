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
    private int imageWidth;
    private int imageHeight;

    public BaseImageGenerator(Controler c, DrawingPanel drawingPanelBase) {
        this.controler = c;
        this.drawingPanelBase = drawingPanelBase;
        setParameters();
    }

    public BufferedImage generateBaseImage() {
        clearShapeList();
        for (int i = 0; i < amount; i++) {
            addShapeList(controler.getRandomShapeFactory().generateShape());
        }
        drawingPanelBase.repaint();
        return drawingPanelBase.getImage();
    }

    public void setParameters(){
        this.amount = controler.getShapeAmount();
        this.imageWidth = controler.getMainWindow().getBaseImageWidth();
        this.imageHeight = controler.getMainWindow().getBaseImageHeight();
        drawingPanelBase.setSize(imageWidth,imageHeight);
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
