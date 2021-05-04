package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;
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

    public Controler(DrawingPanel drawingPanelBase, DrawingPanel drawingPanelFull) {
        this.drawingPanelBase = drawingPanelBase;
        this.drawingPanelFull = drawingPanelFull;
        this.randomShapeFactory = new RandomShapeFactory();
        this.baseImageFactory = new BaseImageGenerator(4,this,drawingPanelBase);
        this.fullImageFactory = new ImageGenerator(this,drawingPanelFull);
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
