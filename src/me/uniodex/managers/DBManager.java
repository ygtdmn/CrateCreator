package me.uniodex.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class DBManager {

    private HashMap<String, FileConfiguration> configurations = new HashMap<String, FileConfiguration>();

    public DBManager() {
        registerConfig("items.yml");
        registerConfig("rrls.yml");
        registerConfig("kasa.yml");

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

    public FileConfiguration getKasaConfig() {
        return configurations.get("kasa.yml");
    }

    public void saveItemsConfig() {
        saveConfig("items.yml");
    }

    public void saveRrlsConfig() {
        saveConfig("rrls.yml");
    }

    public void saveKasaConfig() {
        saveConfig("kasa.yml");
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

    public void deleteFile(File path) {
        if (path.exists()) {
            for (File f : path.listFiles()) {
                if (f.isDirectory()) deleteFile(f);
                else f.delete();
            }
        }
        path.delete();
    }

    public void copyFile(File source, File target) {
        try {
            if (source.isDirectory()) {
                if (!target.exists()) target.mkdirs();
                String files[] = source.list();
                for (String file : files) {
                    File srcFile = new File(source, file);
                    File destFile = new File(target, file);
                    copyFile(srcFile, destFile);
                }

            } else {
                FileInputStream inputStream = new FileInputStream(source);
                FileOutputStream outputStream = new FileOutputStream(target);
                FileChannel inChannel = inputStream.getChannel();
                FileChannel outChannel = outputStream.getChannel();
                try {
                    inChannel.transferTo(0, inChannel.size(), outChannel);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inChannel != null) inChannel.close();
                    if (outChannel != null) outChannel.close();
                    inputStream.close();
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to copy! Exception: " + e);
            e.printStackTrace();
        }
    }

    public void reloadConfig(String fileName) {
        File initialFile = new File("db/"+ fileName);
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

    public long getSize(File file) {
        long length = 0;
        if (file.isDirectory()) {
            for (String f : file.list()) length += getSize(new File(file, f));
        } else length = file.length();
        return length;
    }

}
