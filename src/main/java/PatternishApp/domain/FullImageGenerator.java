/**
 * This class is used to generate a full image from a base image.
 * Transformations are applied to the base image.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.domain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FullImageGenerator {
    private Controler controler;
    private ImageFlipping flipper;
    private BufferedImage fullImage;
    private BufferedImage exportImage;
    private int transformation;
    Random random = new Random();

    public FullImageGenerator(Controler c) {
        this.controler = c;
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

    /*
     * Method that generates a full image. Each case is a different possible transformation.
     * If transformations are added in the future, they need to be added manually into the GUI.
     */
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

    public BufferedImage getFullImage() {
        return fullImage;
    }

    public BufferedImage getExportImage() {
        return exportImage;
    }
}
