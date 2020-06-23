package me.uniodex.guis;

import me.uniodex.CrateCreator;
import me.uniodex.managers.GUIManager;
import me.uniodex.managers.ItemManager;
import me.uniodex.managers.RRLManager;
import me.uniodex.managers.SaveToConfig;
import me.uniodex.objects.Item;
import me.uniodex.objects.RRL;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Mon Feb 11 20:10:54 EET 2019
 */

/**
 * @author Yigit Duman
 */
public class MainGui extends JPanel {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yigit Duman
    private JTabbedPane tabbedPane2;
    private JPanel addItems;
    private JLabel label1;
    private JLabel label2;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JList itemlist;
    private JLabel label3;
    private JTextPane namePanel;
    private JLabel label4;
    private JTextPane rrlPanel;
    private JLabel label6;
    private JTextPane chancePanel;
    private JLabel label12;
    private JTextPane displayItemPanel;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JList rewardsList;
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JPanel addRRL;
    private JLabel label7;
    private JLabel label8;
    private JButton button6;
    private JScrollPane scrollPane3;
    private JList rrllist;
    private JLabel label9;
    private JTextPane rrlNamePanel;
    private JLabel label10;
    private JTextPane rarityLevelPanel;
    private JLabel label11;
    private JTextPane rrlChancePanel;
    private JButton button7;
    private JButton button10;
    public MainGui() {
        initComponents();
    }

    private void addItemButton(MouseEvent e) {
        //TODO Delet this!1
    }

    private void addRRLButtonAction(ActionEvent e) {
        //Add the ubiquitous "Hello World" label.
        AddRRL addRRL = new AddRRL(CrateCreator.frame);
        JDialog dialog = addRRL;

        //Display the window.
        dialog.pack();
        dialog.setVisible(true);
        addRRL.getLabel2().setText("Chance (Remaining: " + RRLManager.getRemainingChance() + "/100):");
    }

    private void button1ActionPerformed(ActionEvent e) {
        //Add the ubiquitous "Hello World" label.
        JDialog dialog = new AddItem(CrateCreator.frame);

        //Display the window.
        dialog.pack();
        dialog.setVisible(true);
    }

    private void itemlistValueChanged(ListSelectionEvent e) {
        if (itemlist.isSelectionEmpty()) {
            return;
        }
        GUIManager.updateSelectedItem(ItemManager.getItem(itemlist.getSelectedValue().toString()));
    }

    private void deleteItemButton(ActionEvent e) {
        if (itemlist.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(CrateCreator.frame, "Seçili eşya yok!");
            return;
        }
        ItemManager.removeItem(ItemManager.getItem(itemlist.getSelectedValue().toString()));
    }

    private void rrllistValueChanged(ListSelectionEvent e) {
        if (rrllist.isSelectionEmpty()) {
            return;
        }
        GUIManager.updateSelectedRRL(RRLManager.getRRL(rrllist.getSelectedValue().toString()));
    }

    private void deleteRRLActionPerformed(ActionEvent e) {
        if (rrllist.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(CrateCreator.frame, "Seçili RRL yok!");
            return;
        }
        RRLManager.removeRRL(RRLManager.getRRL(rrllist.getSelectedValue().toString()));
    }

    private void deleteAllItemsButton(ActionEvent e) {
        java.util.List<Item> items = new ArrayList(ItemManager.getItems());
        for (Item item : items) {
            ItemManager.removeItem(item);
        }
    }

    private void deleteAllRrlsButton(ActionEvent e) {
        java.util.List<RRL> rrls = new ArrayList(RRLManager.getRrls());
        for (RRL rrl : rrls) {
            RRLManager.removeRRL(rrl);
        }
    }

    private void bakeConfigButton(ActionEvent e) {
        JOptionPane.showMessageDialog(CrateCreator.frame, "Kaydetme başladı!");
        SaveToConfig.saveToConfig();
        JOptionPane.showMessageDialog(CrateCreator.frame, "Kaydetme tamamlandı!");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yigit Duman
        tabbedPane2 = new JTabbedPane();
        addItems = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        itemlist = new JList();
        label3 = new JLabel();
        namePanel = new JTextPane();
        label4 = new JLabel();
        rrlPanel = new JTextPane();
        label6 = new JLabel();
        chancePanel = new JTextPane();
        label12 = new JLabel();
        displayItemPanel = new JTextPane();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        rewardsList = new JList();
        button1 = new JButton();
        button4 = new JButton();
        button2 = new JButton();
        addRRL = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        button6 = new JButton();
        scrollPane3 = new JScrollPane();
        rrllist = new JList();
        label9 = new JLabel();
        rrlNamePanel = new JTextPane();
        label10 = new JLabel();
        rarityLevelPanel = new JTextPane();
        label11 = new JLabel();
        rrlChancePanel = new JTextPane();
        button7 = new JButton();
        button10 = new JButton();

        //======== this ========
        setMaximumSize(new Dimension(651, 592));
        setPreferredSize(new Dimension(651, 592));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[80]" +
                        "[]" +
                        "[80]" +
                        "[80]"));

        //======== tabbedPane2 ========
        {

            //======== addItems ========
            {
                addItems.setMinimumSize(new Dimension(484, 550));
                addItems.setPreferredSize(new Dimension(623, 550));
                addItems.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[147,fill]" +
                                "[147,fill]" +
                                "[147,fill]" +
                                "[147,fill]",
                        // rows
                        "[22]0" +
                                "[20]0" +
                                "[13]0" +
                                "[10]0" +
                                "[]0" +
                                "[5]0" +
                                "[38]" +
                                "[76:80]" +
                                "[]"));

                //---- label1 ----
                label1.setText("Items:");
                label1.setLabelFor(itemlist);
                label1.setFont(new Font("Segoe UI", Font.BOLD, 13));
                addItems.add(label1, "cell 0 0");

                //---- label2 ----
                label2.setText("Item Information:");
                label2.setLabelFor(itemlist);
                label2.setFont(new Font("Segoe UI", Font.BOLD, 13));
                addItems.add(label2, "cell 1 0");

                //---- button5 ----
                button5.setText("Delete Item");
                button5.setBackground(Color.red);
                button5.setForeground(Color.white);
                button5.addActionListener(e -> deleteItemButton(e));
                addItems.add(button5, "cell 3 0");

                //======== scrollPane1 ========
                {

                    //---- itemlist ----
                    itemlist.addListSelectionListener(e -> itemlistValueChanged(e));
                    scrollPane1.setViewportView(itemlist);
                }
                addItems.add(scrollPane1, "cell 0 1 1 6,wmin 18%,hmin 78%");

                //---- label3 ----
                label3.setText("Name:");
                label3.setLabelFor(namePanel);
                addItems.add(label3, "cell 1 1,alignx label,growx 0");

                //---- namePanel ----
                namePanel.setText("name");
                namePanel.setEditable(false);
                addItems.add(namePanel, "cell 1 1");

                //---- label4 ----
                label4.setText("RRL:");
                label4.setLabelFor(rrlPanel);
                addItems.add(label4, "cell 1 2,alignx label,growx 0");

                //---- rrlPanel ----
                rrlPanel.setText("rrl");
                rrlPanel.setEditable(false);
                addItems.add(rrlPanel, "cell 1 2");

                //---- label6 ----
                label6.setText("Chance:");
                label6.setLabelFor(chancePanel);
                addItems.add(label6, "cell 1 3,alignx label,growx 0");

                //---- chancePanel ----
                chancePanel.setText("chance");
                chancePanel.setEditable(false);
                addItems.add(chancePanel, "cell 1 3");

                //---- label12 ----
                label12.setText("DisplayItem");
                label12.setLabelFor(displayItemPanel);
                addItems.add(label12, "cell 1 4,alignx label,growx 0");

                //---- displayItemPanel ----
                displayItemPanel.setText("displayItem");
                displayItemPanel.setEditable(false);
                addItems.add(displayItemPanel, "cell 1 4");

                //---- label5 ----
                label5.setText("Rewards:");
                addItems.add(label5, "cell 1 5,aligny top,growy 0");

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(rewardsList);
                }
                addItems.add(scrollPane2, "cell 1 6,aligny top,growy 0");

                //---- button1 ----
                button1.setText("Add Item");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addItemButton(e);
                    }
                });
                button1.addActionListener(e -> button1ActionPerformed(e));
                addItems.add(button1, "cell 0 7");

                //---- button4 ----
                button4.setText("Bake Config");
                button4.addActionListener(e -> bakeConfigButton(e));
                addItems.add(button4, "cell 1 7");

                //---- button2 ----
                button2.setText("Delete All");
                button2.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
                button2.setForeground(Color.white);
                button2.addActionListener(e -> deleteAllItemsButton(e));
                addItems.add(button2, "cell 3 7");
            }
            tabbedPane2.addTab("Add Items", addItems);

            //======== addRRL ========
            {
                addRRL.setMinimumSize(new Dimension(484, 550));
                addRRL.setPreferredSize(new Dimension(623, 550));
                addRRL.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[147,fill]" +
                                "[147,fill]" +
                                "[147,fill]" +
                                "[147,fill]",
                        // rows
                        "[22]0" +
                                "[20]0" +
                                "[13]0" +
                                "[10]0" +
                                "[38]" +
                                "[76:80]" +
                                "[]"));

                //---- label7 ----
                label7.setText("Real Rarity Levels:");
                label7.setLabelFor(rrllist);
                label7.setFont(new Font("Segoe UI", Font.BOLD, 13));
                addRRL.add(label7, "cell 0 0");

                //---- label8 ----
                label8.setText("RRL Information:");
                label8.setLabelFor(rrllist);
                label8.setFont(new Font("Segoe UI", Font.BOLD, 13));
                addRRL.add(label8, "cell 1 0");

                //---- button6 ----
                button6.setText("Delete RRL");
                button6.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
                button6.setForeground(Color.white);
                button6.addActionListener(e -> deleteRRLActionPerformed(e));
                addRRL.add(button6, "cell 3 0");

                //======== scrollPane3 ========
                {

                    //---- rrllist ----
                    rrllist.addListSelectionListener(e -> rrllistValueChanged(e));
                    scrollPane3.setViewportView(rrllist);
                }
                addRRL.add(scrollPane3, "cell 0 1 1 4,wmin 18%,hmin 78%");

                //---- label9 ----
                label9.setText("Name:");
                label9.setLabelFor(rrlNamePanel);
                addRRL.add(label9, "cell 1 1,alignx label,growx 0");

                //---- rrlNamePanel ----
                rrlNamePanel.setText("name");
                addRRL.add(rrlNamePanel, "cell 1 1");

                //---- label10 ----
                label10.setText("Rarity Level:");
                label10.setLabelFor(rarityLevelPanel);
                addRRL.add(label10, "cell 1 2,alignx label,growx 0");

                //---- rarityLevelPanel ----
                rarityLevelPanel.setText("rrl");
                addRRL.add(rarityLevelPanel, "cell 1 2");

                //---- label11 ----
                label11.setText("Chance:");
                label11.setLabelFor(rrlChancePanel);
                addRRL.add(label11, "cell 1 3,alignx label,growx 0");

                //---- rrlChancePanel ----
                rrlChancePanel.setText("chance");
                addRRL.add(rrlChancePanel, "cell 1 3");

                //---- button7 ----
                button7.setText("Add RRL");
                button7.addActionListener(e -> addRRLButtonAction(e));
                addRRL.add(button7, "cell 0 5");

                //---- button10 ----
                button10.setText("Delete All");
                button10.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.shadow"));
                button10.setForeground(Color.white);
                button10.addActionListener(e -> deleteAllRrlsButton(e));
                addRRL.add(button10, "cell 3 5");
            }
            tabbedPane2.addTab("Add RRL", addRRL);
        }
        add(tabbedPane2, "cell 0 1 4 1,wmin 100%,hmin 100%");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JList getItemlist() {
        return itemlist;
    }

    public void setItemlist(JList itemlist) {
        this.itemlist = itemlist;
    }

    public JList getRrllist() {
        return rrllist;
    }

    public void setRrllist(JList rrllist) {
        this.rrllist = rrllist;
    }

    public JTextPane getNamePanel() {
        return namePanel;
    }

    public void setNamePanel(JTextPane namePanel) {
        this.namePanel = namePanel;
    }

    public JTextPane getChancePanel() {
        return chancePanel;
    }

    public void setChancePanel(JTextPane chancePanel) {
        this.chancePanel = chancePanel;
    }

    public JTextPane getRrlPanel() {
        return rrlPanel;
    }

    public void setRrlPanel(JTextPane rrlPanel) {
        this.rrlPanel = rrlPanel;
    }

    public JList getRewardsList() {
        return rewardsList;
    }

    public void setRewardsList(JList rewardsList) {
        this.rewardsList = rewardsList;
    }

    public JTextPane getRrlNamePanel() {
        return rrlNamePanel;
    }

    public void setRrlNamePanel(JTextPane rrlNamePanel) {
        this.rrlNamePanel = rrlNamePanel;
    }

    public JTextPane getRrlChancePanel() {
        return rrlChancePanel;
    }

    public void setRrlChancePanel(JTextPane rrlChancePanel) {
        this.rrlChancePanel = rrlChancePanel;
    }

    public JTextPane getRarityLevelPanel() {
        return rarityLevelPanel;
    }

    public void setRarityLevelPanel(JTextPane rarityLevelPanel) {
        this.rarityLevelPanel = rarityLevelPanel;
    }

    public JTextPane getDisplayItemPanel() {
        return displayItemPanel;
    }

    public void setDisplayItemPanel(JTextPane displayItemPanel) {
        this.displayItemPanel = displayItemPanel;
    }
}
