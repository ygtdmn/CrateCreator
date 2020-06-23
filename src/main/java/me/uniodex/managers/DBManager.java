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

        registerConfig("items.yml");
        registerConfig("rrls.yml");
        registerConfig("crate.yml");

        for (String fileName : configurations.keySet()) {
            reloadConfig(fileName);
            configurations.get(fileName).options().copyDefaults(true);
            saveConfig(fileName);
        }
    }

    public FileConfiguration getItemsConfig() {
        return configurations.get("items.yml");
    }

    public FileConfiguration getRrlsConfig() {
        return configurations.get("rrls.yml");
    }

    public FileConfiguration getCrateConfig() {
        return configurations.get("crate.yml");
    }

    public void saveItemsConfig() {
        saveConfig("items.yml");
    }

    public void saveRrlsConfig() {
        saveConfig("rrls.yml");
    }

    public void saveCrateConfig() {
        saveConfig("crate.yml");
    }

    public void registerConfig(String name) {
        configurations.put(name, YamlConfiguration.loadConfiguration(new File("db/", name)));
    }

    private void saveConfig(String fileName) {
        try {
            configurations.get(fileName).save(new File("db/", fileName));
        } catch (IOException ex) {
            System.out.println("Couldn't save! Exception: " + ex);
        }
    }

    public void reloadConfig(String fileName) {
        File initialFile = new File("db/" + fileName);
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
        File dbDirectory = new File("db");
        dbDirectory.mkdir();

        File crateFile = new File("db/crate.yml");
        if (!crateFile.exists()) {
            copy(getClass().getResourceAsStream("/db/crate.yml"), "db/crate.yml");
        }

        File itemsFile = new File("db/items.yml");
        if (!itemsFile.exists()) {
            copy(getClass().getResourceAsStream("/db/items.yml"), "db/items.yml");
        }

        File rrlsFile = new File("db/rrls.yml");
        if (!rrlsFile.exists()) {
            copy(getClass().getResourceAsStream("/db/rrls.yml"), "db/rrls.yml");
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
