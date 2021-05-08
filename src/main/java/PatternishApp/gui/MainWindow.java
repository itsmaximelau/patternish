package PatternishApp.gui;

import PatternishApp.domain.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends javax.swing.JFrame{
    public Controler controler;
    private JPanel mainPanel;
    private JButton generateButton;
    private DrawingPanel drawingPanelFull;
    private DrawingPanel drawingPanelBase;
    private DrawingPanel drawingPanelExport;
    private JComboBox shapeAmount;
    private JComboBox minNumVertex;
    private JSpinner baseImageHeight;
    private JSpinner baseImageWidth;
    private JComboBox maxNumVertex;
    private JPanel fullImagePanel;
    private JButton addColorBG;
    private JButton showColorButton;
    private JButton addColorButton;
    private JButton showColorButton1;
    private JButton addColorButton1;
    private JButton showColorButton2;
    private JButton addColorButton2;
    private JButton showColorButton3;
    private JCheckBox exclusiveColorsCheckBox;

    public MainWindow(int width, int height){
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        initComponents(width,height);
        mainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (controler.getBaseImage() != null)
                {
                    regenerate();
                }
            }
        });
        addColorBG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseColorBG();
            }
        });
        showColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorBG();
            }
        });
    }

    public void showColorBG(){
        JPanel color = new JPanel();
        color.setSize(10,10);
        color.setBackground(controler.getBGColor());
        JOptionPane.showConfirmDialog(null, color, "Background color", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void chooseColorBG(){
        Color newColor = JColorChooser.showDialog(
                null,
                "Choose Background Color",
                Color.BLACK);
        if (newColor != null){
            controler.setBaseImageBGColor(newColor);
        }
    }

    public void generate(){
        controler.generate();
    }

    public void regenerate(){
        controler.regenerate();
        System.out.println("REGEN");
    }

    public JPanel getFullImagePanel() {
        return fullImagePanel;
    }

    public int getMinNumVertex() {
        return Integer.parseInt(minNumVertex.getSelectedItem().toString());
    }

    public int getMaxNumVertex() {
        return Integer.parseInt(maxNumVertex.getSelectedItem().toString());
    }

    public int getShapeAmount() {
        return Integer.parseInt(shapeAmount.getSelectedItem().toString());
    }

    public int getBaseImageHeight() {
        return Integer.parseInt(baseImageHeight.getValue().toString());
    }

    public int getBaseImageWidth() {
        return Integer.parseInt(baseImageWidth.getValue().toString());
    }

    public Dimension getBaseImageSize(){
        return new Dimension(getBaseImageWidth(),getBaseImageHeight());
    }

    private void initComponents(int width, int height){
        controler = new Controler(drawingPanelBase,drawingPanelFull,drawingPanelExport,this);
        setVisible(true);
        setContentPane(mainPanel);
        setSize(width,height);
        this.setTitle("Patternish");
        shapeAmount.setSelectedIndex(0);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");

        JMenu image = new JMenu("Image");
        JMenuItem export = new JMenuItem("Export");
        JMenuItem saveConfig = new JMenuItem("Save configuration");
        JMenuItem loadConfig = new JMenuItem("Load configuration");
        JMenuItem exit = new JMenuItem("Exit");

        menuBar.add(file);
        file.add(saveConfig);
        file.add(loadConfig);
        file.add(exit);

        menuBar.add(image);
        image.add(export);

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.export();
            }
        });

        this.setSize(width,height);

        baseImageHeight.setValue(Integer.valueOf(100));
        baseImageWidth.setValue(Integer.valueOf(100));
    }

    private void createUIComponents() {
        drawingPanelBase = new DrawingPanel(this, DrawingPanel.panelType.BASE);
        drawingPanelFull = new DrawingPanel(this,DrawingPanel.panelType.FULL);
        drawingPanelExport = new DrawingPanel(this, DrawingPanel.panelType.EXPORT);
    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }
}
