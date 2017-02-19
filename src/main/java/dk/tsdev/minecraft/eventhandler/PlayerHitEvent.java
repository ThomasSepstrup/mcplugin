/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft.eventhandler;


import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;


public class PlayerHitEvent implements Listener {

    @EventHandler
    public void arrowHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            if (event.getHitEntity() != null) {
                if (event.getHitEntity().getType() != EntityType.PLAYER) {
                    Location location = event.getHitEntity().getLocation();
                    location.getWorld().createExplosion(location, 1, true);
                }
            } else if (event.getHitBlock() != null) {
                Location location = event.getHitBlock().getLocation();
                location.getWorld().createExplosion(location, 1, true);

            }
        }
    }
}
