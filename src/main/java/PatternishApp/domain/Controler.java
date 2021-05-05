package PatternishApp.domain;

import PatternishApp.Main;
import PatternishApp.gui.DrawingPanel;
import PatternishApp.gui.MainWindow;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Controler {
    private Drawer drawer = new Drawer(this);
    private BufferedImage baseImage;
    private BufferedImage fullImage;
    private DrawingPanel drawingPanelBase;
    private DrawingPanel drawingPanelFull;
    private RandomShapeFactory randomShapeFactory;
    private BaseImageGenerator baseImageFactory;
    private ImageGenerator fullImageFactory;
    private MainWindow mainWindow;
    private int shapeAmount;

    public Controler(DrawingPanel drawingPanelBase, DrawingPanel drawingPanelFull, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.drawingPanelBase = drawingPanelBase;
        this.drawingPanelFull = drawingPanelFull;
        this.randomShapeFactory = new RandomShapeFactory();
        this.baseImageFactory = new BaseImageGenerator(this,drawingPanelBase);
        this.fullImageFactory = new ImageGenerator(this,drawingPanelFull);
    }

    public int getShapeAmount() {
        this.shapeAmount = mainWindow.getShapeAmount();
        return shapeAmount;
    }

    public BufferedImage generateBaseImage(){
        this.baseImage = baseImageFactory.generateBaseImage();
        return baseImage;
    }

    public BufferedImage generateFullImage(){
        this.fullImage = fullImageFactory.generateFullImage();
        return fullImage;
    }

    public DrawingPanel getDrawingPanelFull() {
        return drawingPanelFull;
    }

    public DrawingPanel getDrawingPanelBase() {
        return drawingPanelBase;
    }

    public BufferedImage getBaseImage() {
        return baseImage;
    }

    public BufferedImage getFullImage() {
        return fullImage;
    }

    public void setMyBaseImage(BufferedImage myBaseImage){
        this.baseImage = myBaseImage;
    }

    public BaseImageGenerator getImageFactory() {
        return baseImageFactory;
    }

    public RandomShapeFactory getRandomShapeFactory() {
        return randomShapeFactory;
    }

}
