package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;
import PatternishApp.gui.MainWindow;

import java.awt.image.BufferedImage;

public class Controler {
    private Drawer drawer = new Drawer(this);
    private BufferedImage baseImage;
    private BufferedImage fullImage;
    private DrawingPanel drawingPanelBase;
    private DrawingPanel drawingPanelFull;
    private RandomShapeFactory randomShapeFactory;
    private BaseImageGenerator baseImageFactory;
    private FullImageGenerator fullImageFactory;
    private MainWindow mainWindow;
    private int shapeAmount;

    public Controler(DrawingPanel drawingPanelBase, DrawingPanel drawingPanelFull, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.drawingPanelBase = drawingPanelBase;
        this.drawingPanelFull = drawingPanelFull;
        this.randomShapeFactory = new RandomShapeFactory(this);
        this.baseImageFactory = new BaseImageGenerator(this,drawingPanelBase);
        this.fullImageFactory = new FullImageGenerator(this,drawingPanelFull);
    }

    public void generate(){
        baseImageFactory.setParameters();
        randomShapeFactory.setParameters();

        drawingPanelFull.setSize(600,600);
        generateBaseImage();
        drawingPanelBase.repaint();
        drawingPanelBase.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test");
        generateFullImage();
        drawingPanelFull.repaint();
        drawingPanelFull.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test1");
        setMyBaseImage(drawingPanelBase.getImage());
    }

    public int getShapeAmount() {
        this.shapeAmount = mainWindow.getShapeAmount();
        return shapeAmount;
    }

    public MainWindow getMainWindow(){
        return mainWindow;
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
