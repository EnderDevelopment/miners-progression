package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("LevelUpPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LevelUpPlugin has been disabled!");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material block = event.getBlock().getType();
        
        if (block == Material.STONE || block == Material.COAL_ORE || block == Material.IRON_ORE || block == Material.GOLD_ORE || block == Material.DIAMOND_ORE) {
            int currentLevel = player.getLevel();
            player.setLevel(currentLevel + 1);
            player.sendMessage(ChatColor.GREEN + "You leveled up! Your new level is: " + (currentLevel + 1));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "Your current level is: " + player.getLevel());
            return true;
        }
        return false;
    }
}