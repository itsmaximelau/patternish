package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageGenerator {
    private Controler controler;
    private DrawingPanel drawingPanelFull;
    private ImageFlipping flipper;

    public ImageGenerator(Controler c, DrawingPanel drawingPanelFull) {
        this.controler = c;
        this.drawingPanelFull = drawingPanelFull;
    }

    public BufferedImage generateFullImage() {
        BufferedImage fullImage = new BufferedImage(500,500, BufferedImage.TYPE_INT_RGB);

        BufferedImage baseImage = controler.getBaseImage();
        BufferedImage transformedImage1 = flipper.flip(baseImage,1);
        BufferedImage transformedImage2 = flipper.flip(baseImage,-1);
        BufferedImage transformedImage3 = flipper.flip(transformedImage2,1);

        Graphics g = fullImage.getGraphics();
        g.drawImage(baseImage, 0,0,null);
        g.drawImage(transformedImage1,250,0,null);
        g.drawImage(transformedImage2,0,250,null);
        g.drawImage(transformedImage3,250,250,null);

        g.dispose();

        return fullImage;
    }
}
