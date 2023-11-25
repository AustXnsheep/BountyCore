package git.austxnsheep.bountycore.Listeners;

import git.austxnsheep.bountycore.Objects.Bounty;
import git.austxnsheep.bountycore.Utils.Data;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener, Data {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Data.createPlayerDataFile(e.getPlayer());
        //public Bounty(String reason, List< ItemStack > items, int money, String target, Player issuer) {
        new Bounty("Test", createItemStackList(), 100, "TestTarget", e.getPlayer());

    }

    private List<ItemStack> createItemStackList() {
        List<ItemStack> items = new ArrayList<>();

        // Creating different ItemStacks
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemStack cookedBeef = new ItemStack(Material.COOKED_BEEF, 16); // 16 cooked beef
        ItemStack enchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemStack oakLog = new ItemStack(Material.OAK_LOG, 32); // 32 oak logs

        // Adding ItemStacks to the list
        items.add(diamondSword);
        items.add(ironPickaxe);
        items.add(cookedBeef);
        items.add(enchantedGoldenApple);
        items.add(oakLog);

        return items;
    }
}
