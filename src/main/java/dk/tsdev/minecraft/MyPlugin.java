/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Thomas
 */
public class MyPlugin extends JavaPlugin {

    private HashMap<String, PlayerState> stateMap;

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getServer().getLogger().info("MyPlugin enabled.");
        getServer().getPluginManager().registerEvents(new PlayerHitEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new TargetPlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockHitEvent(), this);
        stateMap = new HashMap<>();

    }

    @Override
    public void onDisable() {
        super.onDisable();
        Bukkit.getServer().getLogger().info("MyPlugin disabled.");
    }

    public PlayerState getPlayerState(Player player) {

        PlayerState playerState = stateMap.get(player.getDisplayName());

        if (playerState == null) {
            playerState = new PlayerState(player.getDisplayName());
            stateMap.put(player.getDisplayName(), playerState);
            Bukkit.getLogger().info("New PlayerState for: " + player.getDisplayName());
        }

        return playerState;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            PlayerState playerState = getPlayerState(player);

            if (command.getName().equalsIgnoreCase("gpsSet")) {

                Location l = player.getLocation();
                player.setCompassTarget(l);
                playerState.setCompassLocation(l);

                sender.sendMessage("Compas set to this location!");

            } else if (command.getName().equalsIgnoreCase("gpsTP")) {

                if (playerState.getCompassLocation() != null) {
                    player.teleport(playerState.getCompassLocation());
                    sender.sendMessage("Destination reached.");
                } else {
                    player.sendMessage("use gpsSet before gpsTP");
                }

            } else if (command.getName().equalsIgnoreCase("blastaway")) {

                if (args.length == 1) {

                    float force = Float.parseFloat(args[0]);
                    
                    if (playerState.getDetonateLocation() != null) {
                        player.getWorld().createExplosion(playerState.getDetonateLocation(), force, false);
                        player.sendMessage("Kabooom!!");
                    } else {
                        player.sendMessage("Set your blast point!");
                    }
                } else {
                    player.sendMessage("usage: /setblast <force>");
                }
            } else if (command.getName().equalsIgnoreCase("setblast")) {
                playerState.setDetonateLocation(player.getLocation());
                player.sendMessage("Location set. Get the hell out of here!!");
            } else if (command.getName().equalsIgnoreCase("safeon")) {
                playerState.setSafeOn(true);
                player.sendMessage("Safety on!");
            } else if (command.getName().equalsIgnoreCase("safeoff")) {
                playerState.setSafeOn(false);
                player.sendMessage("Safety off!");

            } else if (command.getName().equalsIgnoreCase("kit")) {
                MyPluginHelper.addPlayerKit(player);
            }

        } else {
            sender.sendMessage("This command cannot be used from the console.");
        }

        return true;
    }

}
