package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
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
    private Color bgColor = Color.WHITE;

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
        drawingPanelBase.setBackground(bgColor);
        drawingPanelBase.repaint();
        return drawingPanelBase.getImage();
    }

    public void setBgColor(Color c){
        this.bgColor = c;
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

    public Color getBGColor() {
        return this.bgColor;
    }
}
