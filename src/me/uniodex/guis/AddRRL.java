/*
 * Created by JFormDesigner on Mon Feb 11 21:42:05 EET 2019
 */

package me.uniodex.guis;

import me.uniodex.CrateCreator;
import me.uniodex.managers.ItemManager;
import me.uniodex.managers.RRLManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author Yigit Duman
 */
public class AddRRL extends JDialog {
    public AddRRL(Frame owner) {
        super(owner);
        initComponents();
    }

    public AddRRL(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Add RRL")) {
            RRLManager.addRRL(this.textField1.getText().toString(), Integer.valueOf(this.textField2.getText().toString()));
            this.dispose();
        }
    }

    private void button1MouseReleased(MouseEvent e) {
        // TODO Delete this. Added accidentally.
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yigit Duman
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[100,fill]" +
            "[107,fill]",
            // rows
            "[]0" +
            "[26]0" +
            "[]0" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Name:");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(textField1, "cell 0 1 3 1");

        //---- label2 ----
        label2.setText("Chance (Remaining: x/100):");
        contentPane.add(label2, "cell 0 2");
        contentPane.add(textField2, "cell 0 3 3 1");

        //---- button1 ----
        button1.setText("Add RRL");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
            }
        });
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 0 4 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yigit Duman
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }
}
