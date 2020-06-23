package me.uniodex.objects;

import me.uniodex.managers.RRLManager;

import java.util.List;

public class Item {

    private String name;
    private RRL rrl;
    private List<String> rewards;
    private String displayItem;

    public Item(String name, RRL rrl, String displayItem, List<String> rewards) {
        this.name = name;
        this.rrl = rrl;
        this.rewards = rewards;
        this.displayItem = displayItem;
    }

    public Item(String name, String rrl, String displayItem, List<String> rewards) {
        this.name = name;
        this.rrl = RRLManager.getRRLFromString(rrl);
        this.rewards = rewards;
        this.displayItem = displayItem;
    }

    public String getName() {
        return name;
    }

    public RRL getRRL() {
        return rrl;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public String getDisplayItem() {
        return displayItem;
    }
}
