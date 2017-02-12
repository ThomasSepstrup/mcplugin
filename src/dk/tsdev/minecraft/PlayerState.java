/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.tsdev.minecraft;

import java.io.Serializable;
import org.bukkit.Location;

/**
 *
 * @author Thomas
 */
public class PlayerState implements Serializable {

    private String name;
    private boolean safeOn;
    private Location compassLocation;
    private Location detonateLocation;
    
    
    public PlayerState(String name) {
        
        this.name = name;
        safeOn = false;
        compassLocation = null;
        detonateLocation = null;
        
    }

   
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
