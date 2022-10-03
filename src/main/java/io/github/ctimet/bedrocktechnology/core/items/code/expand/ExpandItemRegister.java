package io.github.ctimet.bedrocktechnology.core.items.code.expand;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.code.RecipeSizeType;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

public class ExpandItemRegister {
    public static void register() {
        new OilMake(
                BItemGroup.MACHINE_CHEAT,
                BItemStacks.BEKT_OIL_MAKE,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        null,
                }
        ).setSize(RecipeSizeType.THREE)
                .setSpeed(1)
                .setCapacity(20000)
                .setEnergyUse(10000)
                .setInvTitle("原油机")
                .register(BektMain.getInstance());
    }
}
