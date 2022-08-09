package io.github.ctimet.bedrocktechnology.core.items.expand;

import io.github.ctimet.bedrocktechnology.core.items.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.BItemRecipeType;
import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import org.bukkit.inventory.ItemStack;

public class ExpandPlayRegister {
    public static void register() {
        BItems.register(
                //原油生成机
                new OilMake(
                        BItemGroup.EXPEND_PLAY,
                        BItemStacks.BEKT_OIL_MAKE,
                        BItemRecipeType.ENHANCED_CRAFTING_TABLE,
                        new ItemStack[]{

                        }
                ).setSpeed(1)
                        .setCapacity(2000)
                        .setEnergyUse(1000)
                        .setInvTitle("原油机")
        );
    }
}
