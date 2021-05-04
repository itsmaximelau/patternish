package PatternishApp.gui;

import PatternishApp.domain.Controler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends javax.swing.JFrame{
    public Controler controler;
    private JPanel mainPanel;
    private JButton generateButton;
    private JTextArea TESTPARAMTextArea;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelBase;

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
        System.out.println(controler.generateBaseImage());
        controler.generateBaseImage();
        drawingPanelBase.repaint();
        drawingPanelBase.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test");
        controler.generateFullImage();
        drawingPanelFull.repaint();
        drawingPanelFull.saveImage("C:\\Users\\Maxime Laurent\\Desktop\\test1");
        controler.setMyBaseImage(drawingPanelBase.getImage());
    }

    private void initComponents(int width, int height){
        controler = new Controler(drawingPanelBase,drawingPanelFull);
        setVisible(true);
        setContentPane(mainPanel);
        setSize(width,height);
        this.setTitle("Patternish");
    }

    private void createUIComponents() {
        drawingPanelBase = new DrawingPanel(this, DrawingPanel.panelType.BASE);
        drawingPanelFull = new DrawingPanel(this,DrawingPanel.panelType.FULL);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
}
