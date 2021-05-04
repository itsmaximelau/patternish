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

    public BaseImageGenerator(int amount, Controler c, DrawingPanel drawingPanelBase) {
        this.amount = amount;
        this.controler = c;
        this.drawingPanelBase = drawingPanelBase;
        System.out.println(drawingPanelBase);
    }

    public BufferedImage generateBaseImage() {
        System.out.println("ICI 1");
        clearShapeList();
        for (int i = 0; i < amount; i++) {
            addShapeList(controler.getRandomShapeFactory().generateShape());
        }
        drawingPanelBase.repaint();
        System.out.println("ICI 2");
        return drawingPanelBase.getImage();
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
