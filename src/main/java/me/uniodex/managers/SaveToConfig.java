package me.uniodex.managers;

import me.uniodex.CrateCreator;
import me.uniodex.objects.Item;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class SaveToConfig {

    public static void saveToConfig() {
        int itemId = 1;
        FileConfiguration kasaConfig = CrateCreator.dbManager.getKasaConfig();

        if (kasaConfig.getConfigurationSection("Crates.Prizes") != null) {
            for (String id : kasaConfig.getConfigurationSection("Crates.Prizes").getKeys(false)) {
                kasaConfig.set("Crates.Prizes" + id + ".DisplayName", 0);
                kasaConfig.set("Crates.Prizes" + id + ".DisplayItem", 0);
                kasaConfig.set("Crates.Prizes" + id + ".DisplayAmount", 0);
                kasaConfig.set("Crates.Prizes" + id + ".MaxRange", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Chance", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Firework", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Glowing", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Player", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Unbreakable", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Commands", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Items", 0);
                kasaConfig.set("Crates.Prizes" + id + ".Messages", 0);
                kasaConfig.set("Crates.Prizes" + id, 0);
            }
            kasaConfig.set("Crates.Prizes", 0);
            CrateCreator.dbManager.saveKasaConfig();
            CrateCreator.dbManager.reloadConfig("kasa.yml");
        }

        for (Item item : ItemManager.getItems()) {
            kasaConfig.set("Crate.Prizes." + itemId + ".DisplayName", RRLManager.getColor(item.getRRL().getName()) + item.getName());
            kasaConfig.set("Crate.Prizes." + itemId + ".DisplayItem", item.getDisplayItem());
            kasaConfig.set("Crate.Prizes." + itemId + ".DisplayAmount", 1);
            kasaConfig.set("Crate.Prizes." + itemId + ".MaxRange", 100000);
            kasaConfig.set("Crate.Prizes." + itemId + ".Chance", (int) ItemManager.calculateChance(item));
            kasaConfig.set("Crate.Prizes." + itemId + ".Firework", false);
            kasaConfig.set("Crate.Prizes." + itemId + ".Glowing", false);
            kasaConfig.set("Crate.Prizes." + itemId + ".Player", "");
            kasaConfig.set("Crate.Prizes." + itemId + ".Unbreakable", false);
            kasaConfig.set("Crate.Prizes." + itemId + ".Commands", new ArrayList<String>());
            kasaConfig.set("Crate.Prizes." + itemId + ".Items", new ArrayList<String>());
            for (String reward : item.getRewards()) {
                List<String> itemlist = kasaConfig.getStringList("Crate.Prizes." + itemId + ".Items");
                List<String> commandlist = kasaConfig.getStringList("Crate.Prizes." + itemId + ".Commands");
                if (reward.startsWith("Item")) {
                    itemlist.add(reward);
                }else {
                    commandlist.add(reward);
                }
                kasaConfig.set("Crate.Prizes." + itemId + ".Items", itemlist);
                kasaConfig.set("Crate.Prizes." + itemId + ".Commands", commandlist);
            }
            kasaConfig.set("Crate.Prizes." + itemId + ".Messages", RRLManager.getColor(item.getRRL().getName()) + item.getName() + " &akazandınız!");
            itemId++;
        }

        CrateCreator.dbManager.saveKasaConfig();
        CrateCreator.dbManager.reloadConfig("kasa.yml");
    }

}
