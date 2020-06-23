package me.uniodex;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import me.uniodex.guis.MainGui;
import me.uniodex.managers.DBManager;
import me.uniodex.managers.GUIManager;
import me.uniodex.managers.ItemManager;
import me.uniodex.managers.RRLManager;

import javax.swing.*;
import java.io.IOException;

public class CrateCreator {

    //TODO Load items and rrls from file and update MainGui

    public static JFrame frame;
    public static MainGui mainGui;
    public static DBManager dbManager;

    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(new PlasticLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        dbManager = new DBManager();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                GUIManager.updateMainGui();
                RRLManager.loadRRLS();
                ItemManager.loadItems();
            }
        });
    }

    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        frame = new JFrame("UnioCrateCreator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        mainGui = new MainGui();
        JPanel panel = mainGui;
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
