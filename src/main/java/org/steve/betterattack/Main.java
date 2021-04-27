package org.steve.betterattack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.List;

public class Main extends JavaPlugin {
    FileConfiguration config;
    @Override
    public void onEnable(){
        if (!getServer().getPluginManager().isPluginEnabled("Essential")){

        }

        GUI.init(this);
        this.getCommand("betterattack").setExecutor(new BACommandExecutor(this));
        this.getServer().getPluginManager().registerEvents(new AttackListener(),this);
        this.getServer().getPluginManager().registerEvents(new GUIListener(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerEvents(),this);

        config = this.getConfig();

    }

    @Override
    public void onDisable(){
        this.saveConfig();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return BACommandExecutor.onTabComplete(sender,command,alias,args);
    }
}
