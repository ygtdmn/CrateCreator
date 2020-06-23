package me.uniodex.managers;

import me.uniodex.CrateCreator;
import me.uniodex.objects.Item;
import me.uniodex.objects.RRL;
import me.uniodex.utils.Utils;
import me.uniodex.utils.config.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private static List<Item> items = new ArrayList<>();

    public static void loadItems() {
        if (CrateCreator.dbManager.getItemsConfig().getConfigurationSection("Items") == null) {
            return;
        }

        for (String id : CrateCreator.dbManager.getItemsConfig().getConfigurationSection("Items").getKeys(false)) {
            String name = CrateCreator.dbManager.getItemsConfig().getString("Items." + id + ".Name");
            RRL rrl = RRLManager.getRRLFromString(CrateCreator.dbManager.getItemsConfig().getString("Items." + id + ".RRL"));
            String displayItem = CrateCreator.dbManager.getItemsConfig().getString("Items." + id + ".DisplayItem");
            List<String> rewards = CrateCreator.dbManager.getItemsConfig().getStringList("Items." + id + ".Rewards");
            addItem(name, rrl, displayItem, rewards, false);
        }
    }

    public static void addItem(String name, RRL rrl, String displayItem, List<String> rewards, boolean config) {
        if (!itemNameExist(name)) {
            if (rrl == null) {
                return;
            }
            items.add(new Item(name, rrl, displayItem, rewards));
        }
        GUIManager.updateMainGui();
        if (config) {
            reloadItemsConfig();
        }
    }

    public static boolean itemNameExist(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static Item getItem(String name) {
        if (itemNameExist(name)) {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(name)) return item;
            }
        }
        return null;
    }

    public static void removeItem(Item item) {
        items.remove(item);
        GUIManager.updateMainGui();
        reloadItemsConfig();
    }

    public static void reloadItemsConfig() {
        int i = 1;

        FileConfiguration itemsConfig = CrateCreator.dbManager.getItemsConfig();
        if (itemsConfig.getConfigurationSection("Items") != null) {
            for (String id : itemsConfig.getConfigurationSection("Items").getKeys(false)) {
                itemsConfig.set("Items." + id + ".Name", 0);
                itemsConfig.set("Items." + id + ".DisplayItem", 0);
                itemsConfig.set("Items." + id + ".RRL", 0);
                itemsConfig.set("Items." + id + ".Rewards", 0);
                itemsConfig.set("Items." + id, 0);
            }
            itemsConfig.set("Items", 0);
            CrateCreator.dbManager.saveItemsConfig();
            CrateCreator.dbManager.reloadConfig("items.yml");
        }

        for (Item item : items) {
            itemsConfig.set("Items." + i + ".Name", item.getName());
            itemsConfig.set("Items." + i + ".DisplayItem", item.getDisplayItem());
            itemsConfig.set("Items." + i + ".RRL", item.getRRL().getName());
            itemsConfig.set("Items." + i + ".Rewards", item.getRewards());
            i++;
        }
        CrateCreator.dbManager.saveItemsConfig();
    }

    public static double calculateChance(Item item) {
        int totalItemsWithThisRRL = 0;

        RRL rrl = item.getRRL();

        for (Item item2 : items) {
            if (item2.getRRL().equals(rrl)) {
                totalItemsWithThisRRL++;
            }
        }

        return Utils.round(Double.valueOf(item.getRRL().getChance()) / Double.valueOf(totalItemsWithThisRRL), 5) * (1000);
    }
}
