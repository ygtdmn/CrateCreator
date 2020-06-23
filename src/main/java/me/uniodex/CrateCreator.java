package me.uniodex;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import me.uniodex.guis.MainGui;
import me.uniodex.managers.DBManager;
import me.uniodex.managers.GUIManager;
import me.uniodex.managers.ItemManager;
import me.uniodex.managers.RRLManager;

import javax.swing.*;

public class CrateCreator {

    //TODO Load items and rrls from file and update MainGui

    public static JFrame frame;
    public static MainGui mainGui;
    public static DBManager dbManager;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new PlasticLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        dbManager = new DBManager();

        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
            GUIManager.updateMainGui();
            RRLManager.loadRRLS();
            ItemManager.loadItems();
        });
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new JFrame("UnioCrateCreator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainGui = new MainGui();
        JPanel panel = mainGui;
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
