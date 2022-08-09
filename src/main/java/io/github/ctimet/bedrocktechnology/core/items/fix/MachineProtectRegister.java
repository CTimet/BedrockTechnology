package io.github.ctimet.bedrocktechnology.core.items.fix;

import io.github.ctimet.bedrocktechnology.core.items.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.BItemRecipeType;
import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.core.items.BItems.item;

public class MachineProtectRegister {
    public static void register() {
        BItems.register(
                new RegisterStick(
                        BItemGroup.MACHINE_PROTECT,
                        BItemStacks.BEKT_SUPERFIX_REG,
                        BItemRecipeType.ENHANCED_CRAFTING_TABLE,
                        new ItemStack[] {
                                null, item(Material.STONE), null,
                                null, item(Material.STONE), null,
                                null, item(Material.STONE), null
                        }
                ),
                new FixStick(
                        BItemGroup.MACHINE_PROTECT,
                        BItemStacks.BEKT_SUPERFIX_FIX,
                        BItemRecipeType.ENHANCED_CRAFTING_TABLE,
                        new ItemStack[] {
                                null, item(Material.REDSTONE), null,
                                null, item(Material.REDSTONE), null,
                                null, item(Material.REDSTONE), null
                        }
                )
        );
    }
}
