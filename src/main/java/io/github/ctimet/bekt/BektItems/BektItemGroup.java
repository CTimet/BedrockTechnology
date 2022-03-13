package io.github.ctimet.bekt.BektItems;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.ctimet.bekt.BektMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BektItemGroup
{
    public static NestedItemGroup Bekt_MainGroup = new NestedItemGroup(BektMain.createKey("BEKT_BEKT_BE"),
            new CustomItemStack(Material.BEDROCK, "&l BEKT &7- &b基岩科技"));
    //基础材料
    public static SubItemGroup Bekt_SubGroup_JCCL = getSubGroup(Material.WHITE_STAINED_GLASS,"&l BEKT &7- &b基础材料");
    //基岩材料
    public static SubItemGroup Bekt_SubGroup_JYCL = getSubGroup(Material.BLACK_STAINED_GLASS,"&l BEKT &7- &c基岩材料");
    //基础机器
    public static SubItemGroup Bekt_SubGroup_JCJQ = getSubGroup(Material.IRON_BLOCK,"&l BEKT &7- &e基础机器");
    //高级机器
    public static SubItemGroup Bekt_SubGroup_GJJQ = getSubGroup(Material.GOLD_BLOCK,"&l BEKT &7- &b高级机器");
    //低级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_DJ = getSubGroup(Material.COAL_ORE,"&l BEKT &7- &7基岩机器_低级");
    //高级基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_GJ = getSubGroup(Material.GOLD_ORE,"&l BEKT &7- &e基岩机器_高级");
    //终极基岩机器
    public static SubItemGroup Bekt_SubGroup_JYJQ_ZJ = getSubGroup(Material.DIAMOND_ORE,"&l BEKT &7- &4基岩机器_终极");
    //基岩发电
    public static SubItemGroup Bekt_SubGroup_JYFD = getSubGroup(Material.REDSTONE_BLOCK,"&l BEKT &7- &4基岩&7发电");
    //基岩工具
    public static SubItemGroup Bekt_SubGroup_JYGJ = getSubGroup(Material.CHISELED_STONE_BRICKS,"&l BEKT &7- &4基岩&7工具");

    
    public static void registerSubCate(){



    }

    public static SubItemGroup getSubGroup(Material material,String name){
        return new SubItemGroup(BektMain.createKey(name),Bekt_MainGroup,new CustomItemStack(material,name));
    }
}
