/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.tsdev.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Thomas
 */
public class BlockSpawn implements Listener {
    
    @EventHandler
    public void spawnGoodies(BlockBreakEvent event) {
        
        Block block = event.getBlock();
        
        //if(block.getType()==Material.DIRT) {
            //block.setType(Material.AIR);
            
            ItemStack itemStack = new ItemStack(Material.COAL, 1);
            
            block.getDrops().add(itemStack);
            Bukkit.getServer().getLogger().info("BlockSpawn");
            Bukkit.getServer().getLogger().info(block.getType().name());        
        //}
        
    }
    
    
}
