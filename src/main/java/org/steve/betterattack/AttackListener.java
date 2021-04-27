package org.steve.betterattack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class AttackListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onAttack(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player){
            Player player=(Player) event.getDamager();
            ItemStack item= player.getInventory().getItem(player.getInventory().getHeldItemSlot());
            {
                ItemMeta im=item.getItemMeta();

            }
        }
    }
}
