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
        BufferedImage baseImage = controler.getBaseImage();
        int width = controler.getDrawingPanelFull().getWidth();
        int height = controler.getDrawingPanelFull().getHeight();
        int baseImageWidth = baseImage.getWidth();
        int baseImageHeight = baseImage.getHeight();
        int fullImageWidth = controler.getDrawingPanelFull().getWidth();
        int fullImageHeight = controler.getDrawingPanelFull().getHeight();

        BufferedImage fullImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Graphics g = fullImage.getGraphics();

        int amountRow = (int) Math.floor(fullImageWidth/baseImageWidth);
        int amountCol = (int) Math.floor(fullImageHeight/baseImageHeight);

        for (int i=0; i<=amountRow; i++){
            for (int n=0; n<amountCol; n++){
                g.drawImage(flipper.flip(baseImage,n%2),baseImageWidth*n,baseImageHeight*i,null);
            }
        }

        g.dispose();

        return fullImage;
    }
}
