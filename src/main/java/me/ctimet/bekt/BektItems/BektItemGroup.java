package me.ctimet.bekt.BektItems;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.ctimet.bekt.BektMain;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BektItemGroup
{
    public static NestedItemGroup Main_Cate = new NestedItemGroup(BektMain.main.keyId,
            new CustomItemStack(Material.BEDROCK, "&4基岩 &7科技&4BEKT"));
    public static SubItemGroup Cate = new SubItemGroup(BektMain.main.keyId, Main_Cate,
            new CustomItemStack(Material.BLACK_STAINED_GLASS, "&e&l SC拓展 &7- &6机器"));
    public static SubItemGroup MatCate = new SubItemGroup(BektMain.main.keyId, Main_Cate,
            new CustomItemStack(Material.GOLD_ORE, "&e&l SC拓展 &7- &d材料"));

    public static void registerSubCate(){

        SlimefunItemStack itemStack = new SlimefunItemStack("MY", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");
        SlimefunItemStack itemStack1 = new SlimefunItemStack("MYS", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");
        SlimefunItemStack itemStack2 = new SlimefunItemStack("MYMY", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");
        ItemStack[] recipe = {
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
        };

        Main_Cate.addSubGroup(Cate);
        Main_Cate.addSubGroup(MatCate);
        SlimefunItem sfItem = new SlimefunItem(Cate, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        SlimefunItem sfItem1 = new SlimefunItem(MatCate, itemStack1, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        SlimefunItem sfItem2 = new SlimefunItem(Main_Cate, itemStack2, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
      //  SlimefunItem sf2 = new SlimefunItem(Main_Cate,(SlimefunItemStack)sfItem,RecipeType.ENHANCED_CRAFTING_TABLE,recipe);
        sfItem.register(BektMain.main);
        sfItem1.register(BektMain.main);
        sfItem2.register(BektMain.main);
    }


}
