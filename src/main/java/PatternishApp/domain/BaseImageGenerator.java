package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseImageGenerator {
    private List<Shape> shapeList = new ArrayList<>();
    private int amount;
    private Controler controler;
    private DrawingPanel drawingPanelBase;
    private int imageWidth;
    private int imageHeight;
    private Color bgColor = new Color(255,102,102);
    private List<Color> shapeColorList = new ArrayList<>();
    Random random = new Random();

    public void setShapeColor(int index, Color color) {
        shapeColorList.set(index, color);
    }

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

    public BufferedImage regenerateBaseImage(){
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
        shapeColorList.add(new Color(161, 228, 230));
        shapeColorList.add(new Color(0,102,102));
        shapeColorList.add(new Color(119,136,153));
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

    public Color getRandomShapeColor(){
        int randColor = random.nextInt(3);
        return shapeColorList.get(randColor);
    }

    public Color getShapeColor(int index) {
        return shapeColorList.get(index);
    }
}
