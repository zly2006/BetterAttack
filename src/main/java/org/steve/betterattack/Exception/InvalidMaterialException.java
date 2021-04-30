package org.steve.betterattack.Exception;

import org.bukkit.Material;

public class InvalidMaterialException extends Exception{
    public Material material;
    public InvalidMaterialException(Material material){
        this.material=material;
    }
    public Material getMaterial(){
        return material;
    }
}
