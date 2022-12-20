package io.github.ctimet.bedrocktechnology.core.items.code.expand;

import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.items.repcie.BRecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExpandItemRegister {
    public static void register() {
        new BCraftingTable(
                BItemGroup.EXPAND_PLAY_CHEAT,
                BItemStacks.BEKT_CRAFTING_TABLE,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        BItems.item(Material.NETHER_STAR), SlimefunItems.ENERGIZED_CAPACITOR, BItems.item(Material.NETHER_STAR),
                        SlimefunItems.POWER_CRYSTAL, BItems.item(Material.CRAFTING_TABLE),     SlimefunItems.POWER_CRYSTAL,
                        BItems.item(Material.NETHER_STAR), SlimefunItems.ENERGIZED_CAPACITOR, BItems.item(Material.NETHER_STAR)
                }
        ).register(BektMain.getInstance());
        new OilMake(
                BItemGroup.EXPAND_PLAY_CHEAT,
                BItemStacks.BEKT_OIL_MAKE,
                BRecipeType.BEKT_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_OBJECT_ENCAPSULATION, BItemStacks.BEKT_OBJECT_ENCAPSULATION, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_WATER_BUMP, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_WATER_BUMP, SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_WATER_BUMP, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_WATER_BUMP, SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_WATER_BUMP, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_CONDUIT, BItemStacks.BEKT_WATER_BUMP, SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_DIG_CORE,   BItemStacks.BEKT_DIG_CORE, BItemStacks.BEKT_DIG_CORE, BItemStacks.BEKT_DIG_CORE,   SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET
                }
        ).setSpeed(1)
                .setCapacity(20000)
                .setEnergyUse(10000)
                .setInvTitle("原油机")
                .register(BektMain.getInstance());
    }
}
