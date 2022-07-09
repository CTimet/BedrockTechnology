package io.github.ctimet.bedrocktechnology.core.items.register;

import io.github.ctimet.bedrocktechnology.core.items.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.BektItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BektRecipeType;
import io.github.ctimet.bedrocktechnology.core.machine.expand.OilMake;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.main;

public final class BektExpandPlay {
    private BektExpandPlay() {}

    public static void register() {
        //原油生成机
        //还是深色主题好看
        new OilMake(
                BektItemGroup.Bekt_SubGroup_KZWF,
                BektItemStacks.BEKT_OIL_MAKE,
                BektRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{

                }
        ).setSpeed(1)
                .setCapacity(2000)
                .setEnergyUse(1000)
                .setInvTitle("原油机")
                .register(main);
    }
}
