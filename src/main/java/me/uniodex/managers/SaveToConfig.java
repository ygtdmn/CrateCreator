package me.uniodex.managers;

import me.uniodex.CrateCreator;
import me.uniodex.objects.Item;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class SaveToConfig {

    public static void saveToConfig() {
        int itemId = 1;
        FileConfiguration crateConfig = CrateCreator.dbManager.getCrateConfig();

        if (crateConfig.getConfigurationSection("Crates.Prizes") != null) {
            for (String id : crateConfig.getConfigurationSection("Crates.Prizes").getKeys(false)) {
                crateConfig.set("Crates.Prizes" + id + ".DisplayName", 0);
                crateConfig.set("Crates.Prizes" + id + ".DisplayItem", 0);
                crateConfig.set("Crates.Prizes" + id + ".DisplayAmount", 0);
                crateConfig.set("Crates.Prizes" + id + ".MaxRange", 0);
                crateConfig.set("Crates.Prizes" + id + ".Chance", 0);
                crateConfig.set("Crates.Prizes" + id + ".Firework", 0);
                crateConfig.set("Crates.Prizes" + id + ".Glowing", 0);
                crateConfig.set("Crates.Prizes" + id + ".Player", 0);
                crateConfig.set("Crates.Prizes" + id + ".Unbreakable", 0);
                crateConfig.set("Crates.Prizes" + id + ".Commands", 0);
                crateConfig.set("Crates.Prizes" + id + ".Items", 0);
                crateConfig.set("Crates.Prizes" + id + ".Messages", 0);
                crateConfig.set("Crates.Prizes" + id, 0);
            }
            crateConfig.set("Crates.Prizes", 0);
            CrateCreator.dbManager.saveCrateConfig();
            CrateCreator.dbManager.reloadConfig("crate.yml");
        }

        for (Item item : ItemManager.getItems()) {
            crateConfig.set("Crate.Prizes." + itemId + ".DisplayName", RRLManager.getColor(item.getRRL().getName()) + item.getName());
            crateConfig.set("Crate.Prizes." + itemId + ".DisplayItem", item.getDisplayItem());
            crateConfig.set("Crate.Prizes." + itemId + ".DisplayAmount", 1);
            crateConfig.set("Crate.Prizes." + itemId + ".MaxRange", 100000);
            crateConfig.set("Crate.Prizes." + itemId + ".Chance", (int) ItemManager.calculateChance(item));
            crateConfig.set("Crate.Prizes." + itemId + ".Firework", false);
            crateConfig.set("Crate.Prizes." + itemId + ".Glowing", false);
            crateConfig.set("Crate.Prizes." + itemId + ".Player", "");
            crateConfig.set("Crate.Prizes." + itemId + ".Unbreakable", false);
            crateConfig.set("Crate.Prizes." + itemId + ".Commands", new ArrayList<String>());
            crateConfig.set("Crate.Prizes." + itemId + ".Items", new ArrayList<String>());
            for (String reward : item.getRewards()) {
                List<String> itemlist = crateConfig.getStringList("Crate.Prizes." + itemId + ".Items");
                List<String> commandlist = crateConfig.getStringList("Crate.Prizes." + itemId + ".Commands");
                if (reward.startsWith("Item")) {
                    itemlist.add(reward);
                } else {
                    commandlist.add(reward);
                }
                crateConfig.set("Crate.Prizes." + itemId + ".Items", itemlist);
                crateConfig.set("Crate.Prizes." + itemId + ".Commands", commandlist);
            }
            // TODO Don't hardcode it.
            crateConfig.set("Crate.Prizes." + itemId + ".Messages", "&aYou won &r" + RRLManager.getColor(item.getRRL().getName()) + item.getName() + "&a!");
            itemId++;
        }

        CrateCreator.dbManager.saveCrateConfig();
        CrateCreator.dbManager.reloadConfig("crate.yml");
    }

}
