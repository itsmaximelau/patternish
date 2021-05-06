package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FullImageGenerator {
    private Controler controler;
    private DrawingPanel drawingPanelFull;
    private ImageFlipping flipper;

    public FullImageGenerator(Controler c, DrawingPanel drawingPanelFull) {
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

        int amountRow = (int) Math.ceil((float) fullImageWidth/baseImageWidth);
        int amountCol = (int) Math.ceil((float) fullImageHeight/baseImageHeight);

        System.out.println("NEW --- ");
        System.out.println("Row " + amountRow);
        System.out.println("Col " + amountCol);
        System.out.println("Full Width " + fullImageWidth);
        System.out.println("Base Width " + baseImageWidth);

        for (int i=0; i<=amountCol; i++){
            for (int n=0; n<amountRow; n++){
                g.drawImage(flipper.flip(baseImage,n%2),baseImageWidth*n,baseImageHeight*i,null);
            }
        }

        g.dispose();

        return fullImage;
    }
}
