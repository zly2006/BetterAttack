package org.steve.betterattack.PluginCommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.steve.betterattack.GUI;
import org.steve.betterattack.Main;

import java.util.ArrayList;
import java.util.List;

public class BACommandExecutor implements CommandExecutor {
    private final Main plugin;

    public BACommandExecutor(Main plugin){
        this.plugin=plugin;
    }

    public static List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> ret=new ArrayList<>();
        ret.add("cp");
        ret.add("help");
        return ret;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equals("betterattack")){
            if(sender instanceof Player){
                Player player=(Player) sender;
                if(args.length==0){
                    sender.sendMessage(new String[]{"BetterAttack攻击强化 /betterattack help打开此页面","/betterattack cp控制面板"});
                    return true;
                }
                switch (args[0]){
                    case "help":
                        sender.sendMessage(new String[]{"BetterAttack攻击强化 /betterattack help打开此页面","/betterattack cp控制面板"});
                        return true;
                    case "cp":
                        ((Player)sender).openInventory(GUI.MainPage);
                        return true;
                    default:
                        return false;
                }
            }
            else{
                sender.sendMessage("需要由玩家执行");
                return true;
            }
        }
        return false;
    }
}
