package git.austxnsheep.bountycore.Objects;

import git.austxnsheep.bountycore.Utils.Data;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SerializableAs("Bounty")
public class Bounty implements Data {
    private String reason;
    private List<ItemStack> items;
    private int money;
    private String target;
    private Player issuer;

    public Bounty(String reason, List<ItemStack> items, int money, String target, Player issuer) {
        this.reason = reason;
        this.items = items;
        this.money = money;
        this.target = target;
        this.issuer = issuer;
        try {
            System.out.println("Attempted to create bounty file...");
            Data.setPlayerData(issuer, "bounty", "TestString");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();
        data.put("reason", this.reason);
        List<Map<String, Object>> serializedItems = new ArrayList<>();
        for (ItemStack item : this.items) {
            serializedItems.add(item.serialize());
        }
        data.put("items", serializedItems);
        data.put("money", this.money);
        data.put("target", this.target);
        data.put("issuerName", this.issuer.getName());
        return data;
    }
}
