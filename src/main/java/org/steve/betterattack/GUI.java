package org.steve.betterattack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    static Main plugin;
    static List<String>PageNames;

    static Inventory MainPage;
    static String MainPageTitle;
    static Inventory CraftingPage;
    static String CraftingPageTitle;
    static ItemStack HelpPage;


    static void setPlugin(Main _plugin){
        plugin=_plugin;
        HelpPage=new ItemStack(Material.WRITTEN_BOOK);
        {
            BookMeta bm= (BookMeta) HelpPage.getItemMeta();
            bm.addPage(
                    "[攻击强化] BetterAttack\n插件使用指南",
                    "权限节点:只有一个betterattack.use  指定了插件是否会监听其动作\n\n命令：/betterattack cp打开主菜单\n使用geyser的基岩版用户可能会显示错位，可使用经典UI档案",
                    ""
            );
            HelpPage.setItemMeta(bm);
        }

        PageNames= new ArrayList<>();
        PageNames.add(MainPageTitle="§3卐攻击强化主菜单卍");
        MainPage= Bukkit.createInventory(null,36,MainPageTitle);
        {
            ItemStack craft=new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta im=craft.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("合成新的武器");
            lore.add("也可以使用某些材料让武器更强");
            im.setLore(lore);
            im.setDisplayName(ChatColor.LIGHT_PURPLE+"合成 & 强化");
            craft.setItemMeta(im);
            ItemStack help=new ItemStack(Material.BOOK);
            im=help.getItemMeta();
            lore=new ArrayList<>();
            lore.add("插件作者倾注了心血凝结成的指导旅者前行的指南");
            lore.add("By Steve");
            im.setLore(lore);
            im.setDisplayName("前行指南");
            help.setItemMeta(im);
            MainPage.setItem(9, craft);
            MainPage.setItem(0,help);
        }
        PageNames.add(CraftingPageTitle="§3卐强化 & 合成卍");
        CraftingPage= Bukkit.createInventory(null, 27,CraftingPageTitle);
        {
            ItemStack empty=new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta im=empty.getItemMeta();
            im.setDisplayName("-");
            empty.setItemMeta(im);
            ItemStack check=new ItemStack(Material.GREEN_DYE);
            im=check.getItemMeta();
            im.setDisplayName("确认合成");
            List<String>lore=new ArrayList<>();
            lore.add("可以在左边预览合成结果，确认后就不能变了哟");
            im.setLore(lore);
            check.setItemMeta(im);
            CraftingPage.setItem(3,empty);
            CraftingPage.setItem(12,empty);
            CraftingPage.setItem(21,empty);
            CraftingPage.setItem(17,check);

        }

    }
}
