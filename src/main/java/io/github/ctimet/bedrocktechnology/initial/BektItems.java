package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.items.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.BektItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BektRecipeType;
import io.github.ctimet.bedrocktechnology.template.Example;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.main;


/**
 * 这是一个有着各种物品配方以及其他内容的类
 * @author CTimet
 * @author CLIEDS
 */
public class BektItems
{
    public static void register()
    {
         /*超级修复-注册*/
         new SlimefunItem(
                BektItemGroup.Bekt_SubGroup_JQBH,
                BektItemStacks.BEKT_CJXF_ZC,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,i(Material.STICK),null,
                        null,i(Material.STICK),null,
                        null,i(Material.STICK),null
                }
         ).register(main);

         /*超级修复-修复*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_JQBH,
                 BektItemStacks.BEKT_CJXF_XF,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{
                         null,i(Material.STONE),null,
                         null,i(Material.STONE),null,
                         null,i(Material.STONE),null
                 }
         ).register(main);

         /*Cloud云组装台*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_WL,
                 BektItemStacks.BEKT_CLOUD_TABLE,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{

                 }
         ).register(main);

         /*Cloud云-v1*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_WL,
                 BektItemStacks.BEKT_CLOUD_V1,
                 BektRecipeType.BEKT_CLOUD_TABLE,
                 new ItemStack[]{

                 }
         ).register(main);
         
         /*光刻机*/
         new SlimefunItem(
                 BektItemGroup.Bekt_SubGroup_XP,
                 BektItemStacks.BEKT_GKJ,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{
                         
                 }
         ).register(main);

         /*测试*/
         new Example(
                 BektItemGroup.Bekt_SubGroup_JQBH,
                 BektItemStacks.BEKT_TEST,
                 BektRecipeType.ENHANCED_CRAFTING_TABLE,
                 new ItemStack[]{

                 }
         ).register(main);

    }

    static CustomItemStack c(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }
    
    static ItemStack i(Material material){
        return new ItemStack(material);
    }
}
