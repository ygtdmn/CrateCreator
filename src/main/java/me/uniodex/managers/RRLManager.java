package me.uniodex.managers;

import me.uniodex.CrateCreator;
import me.uniodex.objects.Item;
import me.uniodex.objects.RRL;

import java.util.ArrayList;
import java.util.List;

public class RRLManager {

    private static List<RRL> rrls = new ArrayList<>();

    public static void loadRRLS() {
        for (String str : CrateCreator.dbManager.getRrlsConfig().getKeys(false)) {
            int i = CrateCreator.dbManager.getRrlsConfig().getInt(str);
            addRRL(str, i);
        }
    }

    public static void addRRL(String name, Integer chance) {
        if (!rrlNameExists(name)) {
            rrls.add(new RRL(name, chance));
            GUIManager.updateMainGui();
            reloadRRLSConfig();
        }
    }

    public static boolean rrlNameExists(String name) {
        for (RRL rrl : rrls) {
            if (rrl.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public static RRL getRRLFromString(String rrlString) {
        for (RRL rrl : rrls) {
            if (rrl.getName().equalsIgnoreCase(rrlString)) return rrl;
        }
        return null;
    }

    public static String getRLFromRRL(String rrl) {
        return rrl.replaceAll("\\d", "");
    }

    public static RRL getRRL(String name) {
        if (rrlNameExists(name)) {
            for (RRL rrl : rrls) {
                if (rrl.getName().equalsIgnoreCase(name)) return rrl;
            }
        }
        return null;
    }

    public static int getRemainingChance() {
        int chance = 0;
        for (RRL rrl : rrls) {
            chance += rrl.getChance();
        }
        return 100 - chance;
    }

    public static List<RRL> getRrls() {
        return rrls;
    }

    public static void removeRRL(RRL rrl) {
        List<Item> items = new ArrayList<>(ItemManager.getItems());
        for (Item item : items) {
            if (item.getRRL().equals(rrl)) {
                ItemManager.removeItem(item);
            }
        }
        rrls.remove(rrl);
        GUIManager.updateMainGui();
        reloadRRLSConfig();
    }

    public static void reloadRRLSConfig() {
        for (RRL rrl : rrls) {
            CrateCreator.dbManager.getRrlsConfig().set(rrl.getName(), rrl.getChance());
        }
        CrateCreator.dbManager.saveRrlsConfig();
        CrateCreator.dbManager.reloadConfig("rrls.yml");
    }

    public static String getColor(String rrl) {
        // TODO Don't hardcode these.
        if (rrl.startsWith("Common")) {
            return "&7";
        }
        if (rrl.startsWith("Rare")) {
            return "&6";
        }
        if (rrl.startsWith("Legendary")) {
            return "&5";
        }
        return null;
    }
}
