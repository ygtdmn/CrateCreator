package me.uniodex.objects;

public class RRL {

    private String name;
    private Integer chance;

    public RRL(String name, Integer chance) {
        this.name = name;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public Integer getChance() {
        return chance;
    }
}
