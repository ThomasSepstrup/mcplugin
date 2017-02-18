/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.tsdev.minecraft;

import java.io.Serializable;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Thomas
 */
public class PlayerState implements Serializable {

    private Player player;
    private boolean safeOn;
    private Location compassLocation;
    private Location detonateLocation;

    public PlayerState(Player player) {
        this.player = player;
        safeOn = false;
        compassLocation = null;
        detonateLocation = null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isSafeOn() {
        return safeOn;
    }

    public void setSafeOn(boolean safeOn) {
        this.safeOn = safeOn;
    }

    public Location getCompassLocation() {
        return compassLocation;
    }

    public void setCompassLocation(Location compassLocation) {
        this.compassLocation = compassLocation;
    }

    public Location getDetonateLocation() {
        return detonateLocation;
    }

    public void setDetonateLocation(Location detonateLocation) {
        this.detonateLocation = detonateLocation;
    }
    
}
