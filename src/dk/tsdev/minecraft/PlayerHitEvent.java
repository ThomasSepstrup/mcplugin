/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftArrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

/**
 *
 * @author Thomas
 */
public class PlayerHitEvent implements Listener {

    @EventHandler
    public void instantKill(EntityDamageByEntityEvent event) {

        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();
            Entity damager = event.getDamager();

            LukasPlugin plugin = (LukasPlugin) player.getServer().getPluginManager().getPlugin("LukasPlugin");

            PlayerState playerState = plugin.getPlayerState(player);

            if (playerState.isSafeOn()) {

                event.setDamage(0d);

                if (!(damager instanceof Player) && (damager instanceof Damageable)) {

                    ((Damageable) damager).damage(500.0d);

                } else if (damager instanceof CraftArrow) {

                    CraftArrow arrow = (CraftArrow) damager;
                    ProjectileSource shooter = arrow.getShooter();

                    if ((shooter instanceof Damageable) && !(shooter instanceof Player)) {

                        ((Damageable) shooter).damage(500.0d);
                    }

                }
            }
        }
    }

}
