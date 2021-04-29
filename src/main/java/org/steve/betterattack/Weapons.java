package org.steve.betterattack;

import org.bukkit.configuration.ConfigurationSection;

public class Weapons {
    Main plugin;
    String displayName;
    int star;
    double damage;
    double damageLevelAdd=0;
    double attackSpeed=1.6;
    double attackSpeedLevelAdd=0;

    public Weapons(Main plugin, ConfigurationSection config){
        this.plugin=plugin;

    }
}
