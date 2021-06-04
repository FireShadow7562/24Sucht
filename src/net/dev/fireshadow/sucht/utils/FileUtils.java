package net.dev.fireshadow.sucht.utils;

import cn.nukkit.utils.Config;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public File directory;
    public static File file;
    public static Config cfg;

    public FileUtils() {
        directory = new File("plugins/24Sucht/");
        file = new File(directory, "config.yml");

        cfg = new Config(file, Config.YAML);
        addDefault("Server-Name", "CB-BLUE-1");
        addDefault("MySQl-Enabled", false);
        saveFile();
    }

    public void addDefault(String key, Object value) {
        if(cfg.get(key) == null)
            cfg.set(key, value);
    }

    public void saveFile() {
        cfg.save(file);
    }

    public void delete() {
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Config getConfig() {
        return cfg;
    }
}
