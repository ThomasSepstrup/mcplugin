/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.Serializable;

/**
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

    Player getPlayer() {
        return player;
    }

    boolean isSafeOn() {
        return safeOn;
    }

    void setSafeOn(boolean safeOn) {
        this.safeOn = safeOn;
    }

    Location getCompassLocation() {
        return compassLocation;
    }

    void setCompassLocation(Location compassLocation) {
        this.compassLocation = compassLocation;
    }

    Location getDetonateLocation() {
        return detonateLocation;
    }

    void setDetonateLocation(Location detonateLocation) {
        this.detonateLocation = detonateLocation;
    }

}
