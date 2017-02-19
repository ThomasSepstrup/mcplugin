package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;


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

    static void caveSearch(PlayerState playerState) {

        Location location = playerState.getPlayer().getLocation();
        World world = playerState.getPlayer().getWorld();


        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        ArrayList<Block> blockColumn = new ArrayList<>();

        for (int y1=0;y1<y;y1++) {
            if(world.getBlockAt(x,y1,z).getType() == Material.AIR) {
                blockColumn.add(world.getBlockAt(x,y1,z));
            }
        }
        playerState.getPlayer().sendMessage(blockColumn.size() + " blocks of air below you.");

    }
}
