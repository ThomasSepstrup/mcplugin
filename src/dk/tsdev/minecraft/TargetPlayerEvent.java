/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft;

import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

/**
 *
 * @author Thomas
 */
public class TargetPlayerEvent implements Listener {

    @EventHandler
    public void peskyMonsters(EntityTargetEvent event) {

        if (event.getTarget() instanceof Player) {

            Player p = (Player) event.getTarget();

            LukasPlugin plugin = (LukasPlugin) p.getServer().getPluginManager().getPlugin("LukasPlugin");

            PlayerState playerState = plugin.getPlayerState(p);

            if (playerState.isSafeOn()) {
                if (event.getEntity() != null && (event.getEntity() instanceof Damageable)) {
                    Damageable d = (Damageable) event.getEntity();

                    Location location = d.getLocation();
                    location = location.add(0, -5, 0);
                    d.teleport(location);
                    d.getWorld().createExplosion(location, 5, true);
                    d.damage(1000d);
                }
            }

        }

    }

}
