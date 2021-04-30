package org.steve.betterattack;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.steve.betterattack.Exception.InvalidMaterialException;

public class Weapons {
    Main plugin;
    String displayName;
    int star;
    Material material;
    String id;
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
    final ItemStack itemStack;

    public Weapons(Main plugin, ConfigurationSection config) throws InvalidMaterialException {
        this.plugin=plugin;
        id=config.getName();
        material=Material.getMaterial(config.getString("material"));
        star=config.getInt("star");
        displayName=config.getString("name");
        if (config.contains("level_repression_limit")){
            LevelRepressionLimit=config.getDouble("level_repression_limit");
        }
        damage=((ConfigurationSection) config.get("damage")).getDouble("value");
        damageLevelAdd=((ConfigurationSection) config.get("damage")).getDouble("add_per_level");
        if (config.contains("attack_speed")){
            attackSpeed=((ConfigurationSection) config.get("attack_speed")).getDouble("value");
            attackSpeedLevelAdd=((ConfigurationSection) config.get("attack_speed")).getDouble("add_per_level");
        }

        itemStack=new ItemStack(material);
        if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE)==null){
            throw new InvalidMaterialException(material);
        }
        String s="";
        for(int i=0;i<star;i++)s+='★';




    }
}
