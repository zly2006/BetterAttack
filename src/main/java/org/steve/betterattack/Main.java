package org.steve.betterattack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin {
    FileConfiguration config;
    Map<String,Weapons>RegisteredWeapons=new HashMap<>();
    Map<String,Items>RegisteredItems=new HashMap<>();
    @Override
    public void onEnable(){
        if (!getServer().getPluginManager().isPluginEnabled("Essential")){

        }

        GUI.init(this);
        this.getCommand("betterattackadmin").setExecutor(new AdminCommandExecutor());
        this.getCommand("betterattack").setExecutor(new BACommandExecutor(this));
        this.getServer().getPluginManager().registerEvents(new AttackListener(),this);
        this.getServer().getPluginManager().registerEvents(new GUIListener(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerEvents(),this);

        config = this.getConfig();
        if (new File("plugins\\BetterAttack\\config.yml")==null){
            this.saveConfig();
        }
        try {
            Map<String,Object>weapons=config.getConfigurationSection("weapon").getValues(false);

        }
        catch (Exception exception){

        }
    }

    @Override
    public void onDisable(){
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return BACommandExecutor.onTabComplete(sender,command,alias,args);
    }
}
