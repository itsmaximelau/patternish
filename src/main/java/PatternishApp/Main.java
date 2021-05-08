package PatternishApp;

import com.formdev.flatlaf.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme." );
        }
        PatternishApp.gui.MainWindow mainWindow = new PatternishApp.gui.MainWindow(1250,800);
    }
}
