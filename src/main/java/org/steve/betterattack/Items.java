package org.steve.betterattack;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

public class Items {
    int star;
    String id;
    String displayName;
    String description;
    Material material;
    public Items(ConfigurationSection config){
        id=config.getName();
        displayName=config.getString("name");
        material=Material.getMaterial(config.getString("material").toUpperCase());
        star=config.getInt("star");
        if(config.contains("description"))
        description=config.getString("description");
    }
}
