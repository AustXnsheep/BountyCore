package git.austxnsheep.bountycore;

import git.austxnsheep.bountycore.Listeners.PlayerJoin;
import git.austxnsheep.bountycore.Utils.Data;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BountyCore extends JavaPlugin implements Data {
    private static BountyCore instance;
    @Override
    public void onEnable() {
        instance = this;
        registerEvent(new PlayerJoin());
    }

    @Override
    public void onDisable() {
    }
    public static BountyCore getInstance() {
        return instance;
    }

    void registerEvent(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }
}
