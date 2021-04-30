package org.steve.betterattack;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class Items {
    final ItemStack itemStack;
    int star;
    String id;
    String displayName;
    String description;
    Material material;
    public Items(Main plugin,ConfigurationSection config){
        id=config.getName();
        displayName=config.getString("name");
        material=Material.getMaterial(config.getString("material").toUpperCase());
        star=config.getInt("star");
        if(config.contains("description"))
        description=config.getString("description");
        itemStack=new ItemStack(material);
        ItemMeta im=itemStack.getItemMeta();
        im.setDisplayName(displayName);
        List<String>lore=new ArrayList<>();
        String s="";
        for(int i=0;i<star;i++)s+='★';
        lore.add(s);
        lore.add(description);
        im.setLore(lore);
        im.getPersistentDataContainer().set(new NamespacedKey(plugin,"id"), PersistentDataType.STRING,id);
        itemStack.setItemMeta(im);
    }
    public ItemStack getItemStack(){
        return itemStack;
    }
}
