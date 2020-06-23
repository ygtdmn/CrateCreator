/*
 * Created by JFormDesigner on Mon Feb 11 21:50:57 EET 2019
 */

package me.uniodex.guis;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yigit Duman
 */
public class Confirmation extends JDialog {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yigit Duman
    private JLabel label1;
    private JButton button1;
    private JButton button2;

    public Confirmation(Frame owner) {
        super(owner);
        initComponents();
    }
    public Confirmation(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yigit Duman
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[147,fill]" +
                        "[160,fill]",
                // rows
                "[]0" +
                        "[9]0" +
                        "[]"));

        //---- label1 ----
        label1.setText("Are you sure about that?");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(label1, "cell 0 0 2 1");

        //---- button1 ----
        button1.setText("Yes");
        contentPane.add(button1, "cell 0 2");

        //---- button2 ----
        button2.setText("Cancel");
        contentPane.add(button2, "cell 1 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
