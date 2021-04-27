package org.steve.betterattack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (event.isCancelled() || !(event.getWhoClicked() instanceof Player)) {
            return;
        }
        if (!GUI.PageNames.contains(event.getView().getTitle())){
            return;
        }
        String title=event.getView().getTitle();
        Player player=(Player) event.getWhoClicked();
        if(title==GUI.MainPageTitle){
            event.setCancelled(true);
            switch (event.getRawSlot()){
                case 9:
                    player.closeInventory();
                    player.openInventory(GUI.CraftingPage);
                    break;
                case 0:
                    player.closeInventory();
                    player.openBook(GUI.HelpPage);
                    player.getInventory().addItem(GUI.HelpPage);
                    break;
                default:
                    break;
            }
        }
        else if(title==GUI.CraftingPageTitle){
            int click=event.getRawSlot();
            if(click>2&&click<9)event.setCancelled(true);
            if(click>11&&click<18)event.setCancelled(true);
            if(click>20&&click<27)event.setCancelled(true);
            if(click==17){
                player.closeInventory();
            }

        }
    }
}
