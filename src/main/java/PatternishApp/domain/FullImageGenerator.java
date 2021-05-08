package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class FullImageGenerator {
    private Controler controler;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelExport;
    private ImageFlipping flipper;
    private BufferedImage fullImage;
    private BufferedImage exportImage;

    public BufferedImage getFullImage() {
        return fullImage;
    }

    public BufferedImage getExportImage() {
        return exportImage;
    }

    public FullImageGenerator(Controler c, DrawingPanel drawingPanelFull, DrawingPanel drawingPanelExport) {
        this.controler = c;
        this.drawingPanelFull = drawingPanelFull;
        this.drawingPanelExport = drawingPanelExport;
    }

    public void generateFullImage(){
        generateImagePanel();
        generateImageExport();
    }

    public void generateImageExport(){
        int exportImageWidth = controler.getDrawingPanelExport().getWidth();
        int exportImageHeight = controler.getDrawingPanelExport().getHeight();

        this.exportImage = generateImage(exportImageWidth,exportImageHeight,0);
    }

    public void generateImagePanel() {
        int fullImageWidth = controler.getDrawingPanelFull().getWidth();
        int fullImageHeight = controler.getDrawingPanelFull().getHeight();

        this.fullImage = generateImage(fullImageWidth,fullImageHeight,0);
    }

    public BufferedImage generateImage(int fullImageWidth, int fullImageHeight, int transformation){
        BufferedImage baseImage = controler.getBaseImage();

        int baseImageWidth = baseImage.getWidth();
        int baseImageHeight = baseImage.getHeight();

        BufferedImage image = new BufferedImage(fullImageWidth,fullImageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        int amountRow = (int) Math.ceil((float) fullImageWidth/baseImageWidth);
        int amountCol = (int) Math.ceil((float) fullImageHeight/baseImageHeight);

        System.out.println(fullImageWidth);
        System.out.println(fullImageHeight);
        System.out.println(amountRow);
        System.out.println(amountCol);

        for (int i=0; i<=amountCol; i++){
            for (int n=0; n<amountRow; n++){
                g.drawImage(flipper.flip(baseImage,n%2),baseImageWidth*n,baseImageHeight*i,null);
            }
        }

        g.dispose();

        return image;
    }
}
