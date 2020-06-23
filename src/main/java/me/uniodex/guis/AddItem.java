/*
 * Created by JFormDesigner on Mon Feb 11 21:46:06 EET 2019
 */

package me.uniodex.guis;

import me.uniodex.CrateCreator;
import me.uniodex.managers.ItemManager;
import me.uniodex.managers.RRLManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Yigit Duman
 */
public class AddItem extends JDialog {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yigit Duman
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel displayItemLabel;
    private JTextField displayItemField;
    private JLabel label3;
    private JTextField textField3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    public AddItem(Frame owner) {
        super(owner);
        initComponents();
    }
    public AddItem(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void onAddReward(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (textField3.getText().isEmpty()) {
                return;
            }

            System.out.println(textField3.getText().toString());

            DefaultListModel listModel;
            if (list1.getModel() instanceof DefaultListModel) {
                listModel = (DefaultListModel) list1.getModel();
            } else {
                listModel = new DefaultListModel();
            }

            listModel.addElement(textField3.getText().toString());
            list1.setModel(listModel);
            textField3.setText("");
        }
    }

    private void deleteReward(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            if (!list1.isSelectionEmpty()) {
                DefaultListModel listModel;
                if (list1.getModel() instanceof DefaultListModel) {
                    listModel = (DefaultListModel) list1.getModel();
                } else {
                    listModel = new DefaultListModel();
                }
                listModel.removeElementAt(list1.getSelectedIndex());
            }
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Add Item")) {

            DefaultListModel listModel;
            if (list1.getModel() instanceof DefaultListModel) {
                listModel = (DefaultListModel) list1.getModel();
            } else {
                JOptionPane.showMessageDialog(CrateCreator.frame, "Ödül koymamışsınız!");
                return;
            }

            java.util.List<String> list = new ArrayList<String>(listModel.getSize());
            for (int i = 0; i < listModel.getSize(); i++) {
                list.add((String) listModel.getElementAt(i));
            }

            if (RRLManager.getRRLFromString(this.textField2.getText().toString()) == null) {
                JOptionPane.showMessageDialog(CrateCreator.frame, "Belirttiğiniz RRL bulunamadı!");
                return;
            }

            ItemManager.addItem(this.textField1.getText().toString(), RRLManager.getRRLFromString(this.textField2.getText().toString()), this.displayItemField.getText().toString(), list, true);
            this.dispose();
        }
    }

    private void onRewardInput(MouseEvent e) {
        //TODO Delet this!1
    }

    private void textField3FocusGained(FocusEvent e) {
        if (this.textField3.getText().toString().equalsIgnoreCase("Press enter to add reward")) {
            this.textField3.setText("");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yigit Duman
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        displayItemLabel = new JLabel();
        displayItemField = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();

        //======== this ========
        setTitle("Add Item");
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
                        "[]0" +
                        "[]0" +
                        "[]0" +
                        "[]0" +
                        "[]0" +
                        "[]" +
                        "[]" +
                        "[]0" +
                        "[]0" +
                        "[]"));

        //---- label1 ----
        label1.setText("Name:");
        contentPane.add(label1, "cell 0 0");
        contentPane.add(textField1, "cell 0 1 3 1");

        //---- label2 ----
        label2.setText("RRL:");
        contentPane.add(label2, "cell 0 2");
        contentPane.add(textField2, "cell 0 3 3 1");

        //---- displayItemLabel ----
        displayItemLabel.setText("Display Item:");
        displayItemLabel.setLabelFor(displayItemField);
        contentPane.add(displayItemLabel, "cell 0 4");
        contentPane.add(displayItemField, "cell 0 5 3 1");

        //---- label3 ----
        label3.setText("Rewards");
        contentPane.add(label3, "cell 0 6");

        //---- textField3 ----
        textField3.setText("Press enter to add reward");
        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                onAddReward(e);
            }
        });
        textField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onRewardInput(e);
            }
        });
        textField3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField3FocusGained(e);
            }
        });
        contentPane.add(textField3, "cell 0 7 3 1");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    deleteReward(e);
                }
            });
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 0 8 3 1");

        //---- button1 ----
        button1.setText("Add Item");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 0 10 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
