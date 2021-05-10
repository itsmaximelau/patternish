/**
 * This class is used to link GUI and Domain.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;
import PatternishApp.gui.MainWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Controler{
    private BufferedImage baseImage;
    private DrawingPanel drawingPanelBase;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelExport;
    private RandomShapeFactory randomShapeFactory;
    private BaseImageGenerator baseImageFactory;
    private FullImageGenerator fullImageFactory;
    private MainWindow mainWindow;
    private int shapeAmount;

    public Controler(DrawingPanel drawingPanelBase, DrawingPanel drawingPanelFull, DrawingPanel drawingPanelExport,MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.drawingPanelBase = drawingPanelBase;
        this.drawingPanelFull = drawingPanelFull;
        this.drawingPanelExport = drawingPanelExport;
        this.randomShapeFactory = new RandomShapeFactory(this);
        this.baseImageFactory = new BaseImageGenerator(this,drawingPanelBase);
        this.fullImageFactory = new FullImageGenerator(this);
    }

    /*
     * Method used to generate a pattern (using Generate button).
     * Used when a pattern needs to be generated for the first time.
     */
    public void generate(){
        baseImageFactory.setParameters();
        randomShapeFactory.setParameters();
        setSizeFullImage();
        setSizeExport();
        generateBaseImage();
        drawingPanelBase.repaint();
        fullImageFactory.generateFullImage();
        drawingPanelExport.repaint();
        drawingPanelFull.repaint();
    }

    /*
     * Method used to regenerate a pattern (using Regenerate button).
     * Used to keep same shapes but apply different transformations or colors.
     */
    public void regenerate(){
        regenerateBaseImage();
        setSizeFullImage();
        fullImageFactory.generateFullImage();
        drawingPanelFull.repaint();
    }

    /*
     * Method used to extend pattern size.
     * Used to keep the pattern exactly the same but smaller/bigger.
     */
    public void resize(){
        setSizeFullImage();
        fullImageFactory.resizeFullImage();
        drawingPanelFull.repaint();
    }

    public void exportWithSettings(String path){
        if (fullImageFactory.getFullImage() != null) {
            setSizeExport();
            resize();
            drawingPanelExport.saveImage(path);
        }
    }

    public BufferedImage generateBaseImage(){
        this.baseImage = baseImageFactory.generateBaseImage();
        return baseImage;
    }

    public BufferedImage regenerateBaseImage(){
        this.baseImage = baseImageFactory.regenerateBaseImage();
        return baseImage;
    }

    public void addShapeColorList(int index, Color color) {
        baseImageFactory.setShapeColor(index,color);
    }

    public void setSizeFullImage(){
        drawingPanelFull.setSize(mainWindow.getFullImagePanel().getWidth()-12, mainWindow.getFullImagePanel().getHeight()-30);
    }

    public void setSizeExport(){
        drawingPanelExport.setSize(mainWindow.getExportImageSize());
    }

    public void setBaseImageBGColor(Color c){
        baseImageFactory.setBgColor(c);
    }

    public Color getBGColor(){
        return baseImageFactory.getBGColor();
    }

    public Color getShapeColor(int index){
        return baseImageFactory.getShapeColor(index);
    }

    public DrawingPanel getDrawingPanelFull() {
        return drawingPanelFull;
    }

    public DrawingPanel getDrawingPanelBase() {
        return drawingPanelBase;
    }

    public DrawingPanel getDrawingPanelExport() {
        return drawingPanelExport;
    }

    public BufferedImage getBaseImage() {
        return baseImage;
    }

    public BufferedImage getFullImage() {
        return fullImageFactory.getFullImage();
    }

    public BufferedImage getExportImage(){
        return fullImageFactory.getExportImage();
    }

    public BaseImageGenerator getImageFactory() {
        return baseImageFactory;
    }

    public RandomShapeFactory getRandomShapeFactory() {
        return randomShapeFactory;
    }

    public int getBorderSize() {
        return mainWindow.getBorderSize();
    }

    public int getTransformation() {
        return mainWindow.getTransformation();
    }

    public int getShapeAmount() {
        this.shapeAmount = mainWindow.getShapeAmount();
        return shapeAmount;
    }

    public MainWindow getMainWindow(){
        return mainWindow;
    }
}
