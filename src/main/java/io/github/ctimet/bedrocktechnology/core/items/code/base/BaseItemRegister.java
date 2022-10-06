package io.github.ctimet.bedrocktechnology.core.items.code.base;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.core.items.repcie.BRecipeType;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.core.items.BItems.item;

public class BaseItemRegister {
    public static void register() {
        new SlimefunItem(
                BItemGroup.BASE_ITEM,
                BItemStacks.BEKT_RESOURCES_FIND,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, null, null,
                        SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.PORTABLE_GEO_SCANNER, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                        null, null, null
                }
        ).register(BektMain.getInstance());
        new SlimefunItem(
                BItemGroup.BASE_ITEM,
                BItemStacks.BEKT_DIG_CORE,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        item(Material.DIAMOND_PICKAXE), SlimefunItems.PROGRAMMABLE_ANDROID_MINER, item(Material.DIAMOND_PICKAXE),
                        BItemStacks.BEKT_RESOURCES_FIND,  SlimefunItems.PROGRAMMABLE_ANDROID_3,   BItemStacks.BEKT_RESOURCES_FIND,
                        item(Material.DIAMOND_PICKAXE), SlimefunItems.PROGRAMMABLE_ANDROID_MINER, item(Material.DIAMOND_PICKAXE)
                }
        ).register(BektMain.getInstance());
        new SlimefunItem(
                BItemGroup.BASE_ITEM,
                BItemStacks.BEKT_CONDUIT,
                BRecipeType.SMELTERY,
                new ItemStack[]{
                        null,                       item(Material.IRON_BLOCK), null,
                        item(Material.IRON_BLOCK),  null,                      item(Material.IRON_BLOCK),
                        null,                       item(Material.IRON_BLOCK), null
                }
        ).register(BektMain.getInstance());
        new SlimefunItem(
                BItemGroup.BASE_ITEM,
                BItemStacks.BEKT_WATER_BUMP,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        SlimefunItems.PLASTIC_SHEET, BItemStacks.BEKT_CONDUIT, SlimefunItems.PLASTIC_SHEET,
                        SlimefunItems.BATTERY,       SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ADVANCED_CIRCUIT_BOARD,
                        SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET,  SlimefunItems.PLASTIC_SHEET
                }
        ).register(BektMain.getInstance());
        new SlimefunItem(
                BItemGroup.BASE_ITEM,
                BItemStacks.BEKT_OBJECT_ENCAPSULATION,
                BRecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, BItemStacks.BEKT_CONDUIT, null,
                        null, BItemStacks.BEKT_WATER_BUMP, null,
                        null, BItemStacks.BEKT_CONDUIT, null
                }
        ).register(BektMain.getInstance());
    }
}
