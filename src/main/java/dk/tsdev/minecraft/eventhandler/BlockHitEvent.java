/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Thomas
 */
public class BlockHitEvent implements Listener {

    @EventHandler
    public void hitBlock(BlockDamageEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = event.getItemInHand();

        if (item.getType() == Material.AIR && block.getType() == Material.STONE) {
            player.damage(1d);
            player.sendMessage("Fjols!!");
        }

    }

}
