package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FullImageGenerator {
    private Controler controler;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelExport;
    private ImageFlipping flipper;
    private BufferedImage fullImage;
    private BufferedImage exportImage;
    private int transformation;
    Random random = new Random();

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
        chooseTransformation();
        generateImagePanel();
        generateImageExport();
    }

    public void resizeFullImage(){
        generateImagePanel();
        generateImageExport();
    }

    public void generateImageExport(){
        int exportImageWidth = controler.getDrawingPanelExport().getWidth();
        int exportImageHeight = controler.getDrawingPanelExport().getHeight();
        this.exportImage = generateImage(exportImageWidth,exportImageHeight);
    }

    public void generateImagePanel() {
        int fullImageWidth = controler.getDrawingPanelFull().getWidth();
        int fullImageHeight = controler.getDrawingPanelFull().getHeight();
        this.fullImage = generateImage(fullImageWidth,fullImageHeight);
    }

    public void chooseTransformation(){
        this.transformation = controler.getTransformation();
        if (transformation == 5){
            transformation = random.nextInt(5);
        }
    }

    public BufferedImage generateImage(int fullImageWidth, int fullImageHeight){
        BufferedImage baseImage = controler.getBaseImage();

        int baseImageWidth = baseImage.getWidth();
        int baseImageHeight = baseImage.getHeight();

        BufferedImage image = new BufferedImage(fullImageWidth,fullImageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        int amountRow = (int) Math.ceil((float) fullImageWidth/baseImageWidth);
        int amountCol = (int) Math.ceil((float) fullImageHeight/baseImageHeight);

        switch(this.transformation){
            case 0:
                for (int i=0; i<=amountCol; i++){
                    for (int n=0; n<amountRow; n++){
                        g.drawImage(flipper.flip(baseImage,n%2),baseImageWidth*n,baseImageHeight*i,null);
                    }
                }
                break;
            case 1:
                for (int i=0; i<=amountCol; i++){
                    for (int n=0; n<amountRow; n++){
                        g.drawImage(flipper.flip(flipper.flip(baseImage,n%2),1),baseImageWidth*n,baseImageHeight*i,null);
                    }
                }
                break;
            case 2:
                for (int i=0; i<=amountCol; i++){
                    baseImage = flipper.flip(baseImage,i%2);
                    for (int n=0; n<amountRow; n++){
                        g.drawImage(flipper.flip(baseImage,n%2),baseImageWidth*n,baseImageHeight*i,null);
                    }
                }
                break;
            case 3:
                for (int i=0; i<=amountCol; i++){
                    baseImage = flipper.flip(baseImage,i%2);
                    for (int n=0; n<amountRow; n++){
                        g.drawImage(flipper.flip(flipper.flip(baseImage,n%2),1),baseImageWidth*n,baseImageHeight*i,null);
                    }
                }
                break;
            case 4:
                for (int i=0; i<=amountCol; i++){
                    baseImage = flipper.flip(flipper.flip(baseImage,i%2),i%1);
                    for (int n=0; n<amountRow; n++){
                        g.drawImage(flipper.flip(flipper.flip(baseImage,n%2),n%1),baseImageWidth*n,baseImageHeight*i,null);
                    }
                }
                break;
        }

        g.dispose();

        return image;
    }
}
