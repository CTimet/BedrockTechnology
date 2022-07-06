package io.github.ctimet.bedrocktechnology.core.items.register;

import io.github.ctimet.bedrocktechnology.core.items.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.BektItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BektRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.main;

public class BektMachineProtect {
    private BektMachineProtect() {
    }

    public static void register() {
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
    }


    static CustomItemStack c(ItemStack itemStack, int n){
        return new CustomItemStack(itemStack,n);
    }

    static ItemStack i(Material material){
        return new ItemStack(material);
    }
}
