package PatternishApp.gui;

import PatternishApp.domain.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends javax.swing.JFrame{
    public Controler controler;
    private JPanel mainPanel;
    private JButton generateButton;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelBase;
    private JPanel paramPanel;
    private JComboBox shapeAmount;
    private JComboBox comboBox2;

    public MainWindow(int width, int height){
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        initComponents(width,height);
    }

    public void generate(){
        drawingPanelBase.setSize(40,40);
        drawingPanelFull.setSize(600,600);
        controler.generateBaseImage();
        drawingPanelBase.repaint();
        drawingPanelBase.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test");
        controler.generateFullImage();
        drawingPanelFull.repaint();
        drawingPanelFull.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test1");
        controler.setMyBaseImage(drawingPanelBase.getImage());
    }

    public int getShapeAmount() {
        return Integer.parseInt(shapeAmount.getSelectedItem().toString());
    }

    private void initComponents(int width, int height){
        controler = new Controler(drawingPanelBase,drawingPanelFull,this);
        setVisible(true);
        setContentPane(mainPanel);
        setSize(width,height);
        this.setTitle("Patternish");
        shapeAmount.setSelectedIndex(1);

        this.setSize(width,height);

    }

    private void createUIComponents() {
        drawingPanelBase = new DrawingPanel(this, DrawingPanel.panelType.BASE);
        drawingPanelFull = new DrawingPanel(this,DrawingPanel.panelType.FULL);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
}
