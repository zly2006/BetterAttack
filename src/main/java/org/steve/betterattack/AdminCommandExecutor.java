package org.steve.betterattack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length==0){
            return false;
        }
        switch(args[0]){
            default:
                return false;
            case "help":
                commandSender.sendMessage(new String[]{
                        "betterattackadmin 帮助页面，可以使用别称/baa",
                        "baa help 显示帮助",
                        "baa give <player> <item>",
                        "baa exp <give|set> <value>",
                        "baa setconfig <path> <value>",
                        "baa add <weapon|item> <config json>"
                });
                break;
        }
        return true;
    }
}
