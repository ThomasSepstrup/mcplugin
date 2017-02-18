/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tsdev.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            PlayerState playerState = getPlayerState((Player) sender);
            CommandHandler commandHandler = new CommandHandler();

            String commandText = command.getName().toLowerCase();

            switch (commandText) {
                case "gpsSet":
                    commandHandler.handleGpsSet(playerState);
                    break;
                case "gpsTP":
                    commandHandler.handleGpsTeleport(playerState);
                    break;
                case "blastaway":
                    if (args.length == 1) {
                        commandHandler.handleBlastAway(args[0], playerState);
                    } else {
                        sender.sendMessage("usage: /blastaway <force>");
                    }
                    break;
                case "setblast":
                    commandHandler.handleSetBlast(playerState);
                    break;
                case "safeon":
                    commandHandler.handleSafeOn(playerState);
                    break;
                case "safeoff":
                    commandHandler.handleSafeOff(playerState);
                    break;
                case "kit":
                    commandHandler.handleKit(playerState);
                    break;
            }

        } else {
            sender.sendMessage("Fool! This command cannot be used from the console.");
        }

        return true;
    }

    public PlayerState getPlayerState(Player player) {

        PlayerState playerState = stateMap.get(player.getDisplayName());
        if (playerState == null) {
            playerState = new PlayerState(player);
            stateMap.put(player.getDisplayName(), playerState);
            Bukkit.getLogger().info("New PlayerState for: " + player.getDisplayName());
        }
        return playerState;
    }

}
