package dk.tsdev.minecraft.eventhandler;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CommandHandler {

    public void handleGpsSet(PlayerState playerState) {
        Player player = playerState.getPlayer();
        Location location = player.getLocation();
        player.setCompassTarget(location);
        playerState.setCompassLocation(location);
        player.sendMessage("Compas set to this location!");
    }

    public void handleGpsTeleport(PlayerState playerState) {

        Player player = playerState.getPlayer();
        if (playerState.getCompassLocation() != null) {
            player.teleport(playerState.getCompassLocation());
            player.sendMessage("Destination reached.");
        } else {
            player.sendMessage("use gpsSet before gpsTP");
        }
    }

    public void handleSafeOn(PlayerState playerState) {
        Player player = playerState.getPlayer();
        playerState.setSafeOn(true);
        player.sendMessage("Safety on!");
    }

    public void handleSetBlast(PlayerState playerState) {
        Player player = playerState.getPlayer();
        playerState.setDetonateLocation(player.getLocation());
        player.sendMessage("Location set. Get the hell out of here!!");
    }

    public void handleBlastAway(String arg, PlayerState playerState) {
        Player player = playerState.getPlayer();
        float force = Float.parseFloat(arg);

        if (playerState.getDetonateLocation() != null) {
            player.getWorld().createExplosion(playerState.getDetonateLocation(), force, false);
            player.sendMessage("Kabooom!!");
        } else {
            player.sendMessage("Set your blast point!");
        }
    }

    public void handleSafeOff(PlayerState playerState) {
        Player player = playerState.getPlayer();
        playerState.setSafeOn(false);
        player.sendMessage("Safety off!");
    }

    public void handleKit(PlayerState playerState) {
        MyPluginHelper.addPlayerKit(playerState);
    }


}
