package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.repcie.BRecipeType;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.core.items.BItems.item;

public class MachineProtectRegister {
    public static void register() {
        new RegisterStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_SUPERFIX_REG,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null
                }
        ).register(BektMain.getInstance());
        new FixStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_SUPERFIX_FIX,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, item(Material.REDSTONE), null,
                        null, item(Material.REDSTONE), null,
                        null, item(Material.REDSTONE), null
                }
        ).register(BektMain.getInstance());
        new FixAllStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_FIX_ALL,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, BItemStacks.BEKT_SUPERFIX_FIX, null,
                        null, BItemStacks.BEKT_SUPERFIX_FIX, null,
                        null, BItemStacks.BEKT_SUPERFIX_FIX, null
                }
        ).register(BektMain.getInstance());
    }
}
