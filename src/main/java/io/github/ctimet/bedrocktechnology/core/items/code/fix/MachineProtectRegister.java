package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.repcie.BRecipeType;
import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.core.items.BItems.item;

public class MachineProtectRegister {
    public static void register() {
        new RegisterStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_REGISTER_STICK,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null
                }
        ).register(BektMain.getInstance());
        new FixStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_FIX_STICK,
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
                        null, BItemStacks.BEKT_FIX_STICK, null,
                        null, BItemStacks.BEKT_FIX_STICK, null,
                        null, BItemStacks.BEKT_FIX_STICK, null
                }
        ).register(BektMain.getInstance());
        new OwnerRegisterStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_OWNER_REGISTER,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, BItemStacks.BEKT_REGISTER_STICK, null,
                        null, BItemStacks.BEKT_REGISTER_STICK, null,
                        null, BItemStacks.BEKT_REGISTER_STICK, null
                }
        ).register(BektMain.getInstance());
        new OwnerFixAllStick(
                BItemGroup.MACHINE_PROTECT,
                BItemStacks.BEKT_OWNER_FIX_ALL,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, BItemStacks.BEKT_FIX_ALL, null,
                        null, BItemStacks.BEKT_FIX_ALL, null,
                        null, BItemStacks.BEKT_FIX_ALL, null
                }
        ).register(BektMain.getInstance());
    }
}
