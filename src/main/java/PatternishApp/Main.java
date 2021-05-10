/**
 * Main class for Patternish.
 *
 * @author  itsmaximelau
 * @version 1.0
 * @since   2021-05-09
 */

package PatternishApp;

import com.formdev.flatlaf.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Try catch block to define UI theme.
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme." );
        }
        //Instantiation of the mainWindow, with pre-defined size.
        PatternishApp.gui.MainWindow mainWindow = new PatternishApp.gui.MainWindow(1250,800);
    }
}
