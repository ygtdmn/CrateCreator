package me.uniodex.managers;

import me.uniodex.utils.config.FileConfiguration;
import me.uniodex.utils.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class DBManager {

    private Map<String, FileConfiguration> configurations = new HashMap<>();

    public DBManager() {
        saveDefaultConfig();

        registerConfig("db/items.yml");
        registerConfig("db/rrls.yml");
        registerConfig("db/crate.yml");
        registerConfig("config.yml");

        for (String fileName : configurations.keySet()) {
            reloadConfig(fileName);
            configurations.get(fileName).options().copyDefaults(true);
            saveConfig(fileName);
        }
    }

    public FileConfiguration getItemsConfig() {
        return configurations.get("db/items.yml");
    }

    public FileConfiguration getRrlsConfig() {
        return configurations.get("db/rrls.yml");
    }

    public FileConfiguration getCrateConfig() {
        return configurations.get("db/crate.yml");
    }

    public FileConfiguration getMainConfig() {
        return configurations.get("config.yml");
    }

    public void saveItemsConfig() {
        saveConfig("db/items.yml");
    }

    public void saveRrlsConfig() {
        saveConfig("db/rrls.yml");
    }

    public void saveCrateConfig() {
        saveConfig("db/crate.yml");
    }

    public void saveMainConfig() {
        saveConfig("config.yml");
    }

    public void registerConfig(String name) {
        configurations.put(name, YamlConfiguration.loadConfiguration(new File("CrateCreator/" + name)));
    }

    private void saveConfig(String fileName) {
        try {
            configurations.get(fileName).save(new File("CrateCreator/" + fileName));
        } catch (IOException ex) {
            System.out.println("Couldn't save! Exception: " + ex);
        }
    }

    public void reloadConfig(String fileName) {
        File initialFile = new File("CrateCreator/" + fileName);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(reader);
            configurations.get(fileName).setDefaults(defConfig);
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveDefaultConfig() {
        File dbDirectory = new File("CrateCreator/db");
        dbDirectory.mkdir();

        File crateFile = new File("CrateCreator/db/crate.yml");
        if (!crateFile.exists()) {
            copy(getClass().getResourceAsStream("/db/crate.yml"), "CrateCreator/db/crate.yml");
        }

        File itemsFile = new File("CrateCreator/db/items.yml");
        if (!itemsFile.exists()) {
            copy(getClass().getResourceAsStream("/db/items.yml"), "CrateCreator/db/items.yml");
        }

        File rrlsFile = new File("CrateCreator/db/rrls.yml");
        if (!rrlsFile.exists()) {
            copy(getClass().getResourceAsStream("/db/rrls.yml"), "CrateCreator/db/rrls.yml");
        }

        File configFile = new File("CrateCreator/config.yml");
        if (!configFile.exists()) {
            copy(getClass().getResourceAsStream("/config.yml"), "CrateCreator/config.yml");
        }
    }

    public static void copy(InputStream source, String destination) {
        try {
            Files.copy(source, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
