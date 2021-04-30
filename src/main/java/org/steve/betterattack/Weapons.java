package org.steve.betterattack;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class Weapons {
    Main plugin;
    String displayName;
    int star;
    Material material;
    double damage;
    double damageLevelAdd=0;
    double attackSpeed=1.6;
    double attackSpeedLevelAdd=0;
    double durability=50;
    double durabilityLevelAdd=0;
    double SuccessAttackRateAdd=0;
    double SuccessAttackRateAddLevelAdd=0;
    double CritRate=0.05;
    double CritRateLevelAdd=0;
    double CritDamage=0.5;
    double CritDamageLevelAdd=0;
    double LevelRepression=0;
    double LevelRepressionLevelAdd=0;
    double LevelRepressionLimit=0;
    double LevelRepressionLimitLevelAdd=0;
    final ItemStack itemStack;

    public Weapons(Main plugin, ConfigurationSection config){
        this.plugin=plugin;
        material=Material.getMaterial(config.getString("material"));

        itemStack=new ItemStack(material);
        String s="";
        star=config.getInt("star");
        for(int i=0;i<star;i++)s+='★';




    }
}
