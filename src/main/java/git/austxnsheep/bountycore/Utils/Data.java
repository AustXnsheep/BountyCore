package git.austxnsheep.bountycore.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public interface Data {
    String fileDir = "plugins/BountyCore/data";

    static File getPlayerDataFile(UUID uuid) {
        return new File(fileDir, uuid.toString() + ".yml");
    }

    static YamlConfiguration getPlayerDataConfig(UUID uuid) {
        System.out.println("Test 2");
        return YamlConfiguration.loadConfiguration(getPlayerDataFile(uuid));
    }

    static void savePlayerData(Player player) {
        File file = getPlayerDataFile(player.getUniqueId());
        YamlConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(file);
        try {
            playerDataConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createPlayerDataFile(Player player) {
        UUID playerUUID = player.getUniqueId();
        String fileName = playerUUID + ".yml";
        File dataFolder = new File(fileDir);
        File playerDataFile = new File(dataFolder, fileName);
        try {
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }
            if (!playerDataFile.exists()) {
                playerDataFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void setPlayerData(Player player, String key, Object value) {
        System.out.println("Test 1");
        YamlConfiguration playerDataConfig = getPlayerDataConfig(player.getUniqueId());
        playerDataConfig.set(key, value);
    }

    static Object getPlayerData(Player player, String key) {
        YamlConfiguration playerDataConfig = getPlayerDataConfig(player.getUniqueId());
        return playerDataConfig.get(key);
    }
}
