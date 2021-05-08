package PatternishApp.domain;

import PatternishApp.gui.DrawingPanel;
import PatternishApp.gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.nio.Buffer;

public class Controler {
    private Drawer drawer = new Drawer(this);
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
        this.fullImageFactory = new FullImageGenerator(this,drawingPanelFull,drawingPanelExport);
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

    public void regenerate(){
        regenerateBaseImage();
        setSizeFullImage();
        fullImageFactory.generateFullImage();
        drawingPanelFull.repaint();
    }

    public void resize(){
        setSizeFullImage();
        fullImageFactory.generateFullImage();
        drawingPanelFull.repaint();
    }

    public void exportWithSettings(String path){
        if (fullImageFactory.getFullImage() != null) {
            setSizeExport();
            resize();
            drawingPanelExport.saveImage(path);
            //drawingPanelExport.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\myImage",0);
        }
    }

    public void setSizeFullImage(){
        drawingPanelFull.setSize(mainWindow.getFullImagePanel().getWidth()-12, mainWindow.getFullImagePanel().getHeight()-30);
    }

    public void setSizeExport(){
        drawingPanelExport.setSize(mainWindow.getExportImageSize());
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

    public BufferedImage regenerateBaseImage(){
        this.baseImage = baseImageFactory.regenerateBaseImage();
        return baseImage;
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

    public void setMyBaseImage(BufferedImage myBaseImage){
        this.baseImage = myBaseImage;
    }

    public BaseImageGenerator getImageFactory() {
        return baseImageFactory;
    }

    public RandomShapeFactory getRandomShapeFactory() {
        return randomShapeFactory;
    }

    public void addShapeColorList(int index, Color color) {
        baseImageFactory.setShapeColor(index,color);
    }
}
