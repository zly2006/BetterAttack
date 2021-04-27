package org.steve.betterattack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
        event.getPlayer().sendMessage(new String[]{"欢迎使用攻击强化插件","此插件正在测试，欢迎反馈bug"});
        if(event.getPlayer().isOp()){
            event.getPlayer().sendMessage("你可以输入/betterattack license查看插件使用许可，或者在wwww.starlight.cool:9801查看更多信息(实验性)");
        }
    }
}
