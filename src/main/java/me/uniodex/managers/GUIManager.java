package me.uniodex.managers;

import me.uniodex.CrateCreator;
import me.uniodex.guis.MainGui;
import me.uniodex.objects.Item;
import me.uniodex.objects.RRL;

import javax.swing.*;
import java.util.List;

public class GUIManager {

    public static void updateMainGui() {
        updateItems(ItemManager.getItems());
        updateRRLs(RRLManager.getRrls());

        /*JList itemList = MainGui.getItemlist();

        DefaultListModel model = (DefaultListModel) itemList.getModel();
        model.addElement("Test");

        itemList.setModel(model);

        MainGui.setItemlist(itemList);*/
    }

    public static void updateItems(List<Item> items) {
        clearList(CrateCreator.mainGui.getItemlist());
        if (items.size() <= 0) {
            updateSelectedItem(null);
            return;
        }

        DefaultListModel listModel = new DefaultListModel();

        for (Item item : items) {
            listModel.addElement(item.getName());
            CrateCreator.mainGui.getItemlist().setModel(listModel);
        }
        updateSelectedItem(items.get(items.size()-1));
        if (items.size() > 0) {
            CrateCreator.mainGui.getItemlist().setSelectedIndex(items.size() - 1);
        }
    }

    public static void updateRRLs(List<RRL> rrls) {
        clearList(CrateCreator.mainGui.getRrllist());
        if (rrls.size() <= 0) {
            updateSelectedRRL(null);
            return;
        }

        DefaultListModel listModel = new DefaultListModel();

        for (RRL rrl : rrls) {
            /*DefaultListModel listModel;
            if (CrateCreator.mainGui.getRrllist().getModel() instanceof DefaultListModel) {
                listModel = (DefaultListModel) CrateCreator.mainGui.getRrllist().getModel();
            }else {
                listModel = new DefaultListModel();
            }*/

            listModel.addElement(rrl.getName());
            CrateCreator.mainGui.getRrllist().setModel(listModel);
        }
        updateSelectedRRL(rrls.get(rrls.size()-1));
        if (rrls.size() > 0) {
            CrateCreator.mainGui.getRrllist().setSelectedIndex(rrls.size() - 1);
        }
    }

    public static void updateSelectedItem(Item item) {
        if (item == null) {
            CrateCreator.mainGui.getNamePanel().setText("Seçilmedi");
            CrateCreator.mainGui.getChancePanel().setText("0");
            CrateCreator.mainGui.getRrlPanel().setText("Seçilmedi");
            CrateCreator.mainGui.getDisplayItemPanel().setText("Seçilmedi");
            clearList(CrateCreator.mainGui.getRewardsList());
            return;
        }
        CrateCreator.mainGui.getNamePanel().setText(item.getName());
        CrateCreator.mainGui.getChancePanel().setText(""+ItemManager.calculateChance(item));
        CrateCreator.mainGui.getRrlPanel().setText(item.getRRL().getName());
        CrateCreator.mainGui.getDisplayItemPanel().setText(item.getDisplayItem());
        updateRewards(item.getRewards());
    }

    public static void updateRewards(List<String> rewards) {
        if (rewards.size() <= 0) return;
        clearList(CrateCreator.mainGui.getRewardsList());

        DefaultListModel listModel = new DefaultListModel();

        for (String reward : rewards) {
            listModel.addElement(reward);
            CrateCreator.mainGui.getRewardsList().setModel(listModel);
        }
    }

    public static void updateSelectedRRL(RRL rrl) {
        if (rrl == null) {
            CrateCreator.mainGui.getRrlNamePanel().setText("Seçilmedi");
            CrateCreator.mainGui.getRrlChancePanel().setText("0");
            CrateCreator.mainGui.getRarityLevelPanel().setText("Seçilmedi");
            return;
        }
        CrateCreator.mainGui.getRrlNamePanel().setText(rrl.getName());
        CrateCreator.mainGui.getRrlChancePanel().setText(rrl.getChance().toString());
        CrateCreator.mainGui.getRarityLevelPanel().setText(RRLManager.getRLFromRRL(rrl.getName()));
    }

    public static void clearList(JList list) {
        DefaultListModel listModel;
            if (list.getModel() instanceof DefaultListModel) {
                listModel = (DefaultListModel) list.getModel();
            }else {
                listModel = new DefaultListModel();
            }

            listModel.clear();
    }
}
