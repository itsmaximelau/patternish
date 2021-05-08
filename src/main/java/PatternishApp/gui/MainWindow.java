package PatternishApp.gui;

import PatternishApp.domain.Controler;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

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
    private JButton addColorShape1;
    private JButton showColorShape1;
    private JButton addColorShape2;
    private JButton showColorButton2;
    private JButton addColorShape3;
    private JButton showColorShape3;
    private JButton generateColors;
    private JSpinner exportImageWidth;
    private JSpinner exportImageHeight;

    public MainWindow(int width, int height){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    resize();
                    System.out.println(controler.getDrawingPanelFull().getSize());
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
        addColorShape1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseColorShape(0);
            }
        });
        addColorShape2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseColorShape(1);
            }
        });
        addColorShape3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseColorShape(2);
            }
        });
        generateColors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regenerate();
            }
        });
        showColorShape1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorShape(0);
            }
        });
        showColorButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorShape(1);
            }
        });
        showColorShape3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorShape(2);
            }
        });
    }

    public void showColorShape(int index){
        JPanel color = new JPanel();
        color.setSize(10,10);
        color.setBackground(controler.getShapeColor(index));
        JOptionPane.showConfirmDialog(null, color, "Shape color", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    public void chooseColorShape(int index){
        Color newColor = JColorChooser.showDialog(
                null,
                "Choose Shape Color",
                Color.BLACK);
        if (newColor != null){
            controler.addShapeColorList(index, newColor);
        }
    }

    public void addShapeColorList(int index, Color color){
        controler.addShapeColorList(index,color);
    }

    public void showColorBG(){
        JPanel color = new JPanel();
        color.setSize(10,10);
        color.setBackground(controler.getBGColor());
        JOptionPane.showConfirmDialog(null, color, "Background color", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
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
        if (controler.getBaseImage() != null){
            controler.regenerate();
        }
    }

    public void resize(){
        controler.resize();
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

    public int getExportImageWidth(){
        return Integer.parseInt(exportImageWidth.getValue().toString());
    }

    public int getExportImageHeight(){
        return Integer.parseInt(exportImageHeight.getValue().toString());
    }

    public Dimension getExportImageSize() {
        return new Dimension(getExportImageWidth(),getExportImageHeight());
    }

    private void initComponents(int width, int height){
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.setVisible(true);

        JMenu actions = new JMenu("Actions");

        JMenuItem exportWithSettings = new JMenuItem("Export");
        JMenuItem exit = new JMenuItem("Exit");

        menuBar.add(actions);
        actions.add(exportWithSettings);
        actions.add(exit);

        controler = new Controler(drawingPanelBase,drawingPanelFull,drawingPanelExport,this);
        setVisible(true);
        setContentPane(mainPanel);
        setSize(width,height);
        this.setTitle("Patternish");
        shapeAmount.setSelectedIndex(2);
        maxNumVertex.setSelectedIndex(1);

        exportWithSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    controler.exportWithSettings(selectedFile.getAbsolutePath());
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setSize(width,height);

        baseImageWidth.setValue(Integer.valueOf(62));
        baseImageHeight.setValue(Integer.valueOf(80));

        exportImageWidth.setValue(Integer.valueOf(1920));
        exportImageHeight.setValue(Integer.valueOf(1080));

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
