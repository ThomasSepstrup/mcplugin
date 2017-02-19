package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


class MyPluginHelper {

    static void addPlayerKit(PlayerState playerState) {

        Player player = playerState.getPlayer();
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
        player.getInventory().addItem(new ItemStack(Material.BOW, 1));
        player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
        player.getInventory().addItem(new ItemStack(Material.IRON_SPADE, 1));
        player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
        player.getInventory().addItem(new ItemStack(Material.FURNACE, 1));
        player.getInventory().addItem(new ItemStack(Material.WORKBENCH, 1));
        player.getInventory().addItem(new ItemStack(Material.TORCH, 10));
        player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 10));
        player.getInventory().addItem(new ItemStack(Material.ARROW, 40));
        player.getInventory().addItem(new ItemStack(Material.COAL, 10));
    }
}
