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
    private DrawingPanel drawingPanel;

    public MainWindow(int width, int height){
        controler = new Controler();
        setVisible(true);
        setContentPane(mainPanel);
        setSize(width,height);
        this.setTitle("Patternish");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        initComponents();
    }

    public void generate(){
        controler.generateNewShapes(4);
        drawingPanel.repaint();
    }

    private void initComponents(){
    }

    private void createUIComponents() {
        drawingPanel = new DrawingPanel(this);
    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }
}
