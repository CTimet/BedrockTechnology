package io.github.ctimet.bedrocktechnology.core.items.network;

import io.github.ctimet.bedrocktechnology.core.items.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.ctimet.bedrocktechnology.core.items.BItems.*;

public class NetWorkRegister {
    public static void register() {
        BItems.register(
                new Cloud(
                        BItemGroup.NETWORK,
                        BItemStacks.BEKT_CLOUD,
                        BItemRecipeType.BEKT_CLOUD_TABLE,
                        BErrorItem.getErrRecipe()
                ),
                new ItemRecipeShow(
                        BItemGroup.NETWORK,
                        BItemStacks.BEKT_RECIPES_SHOW,
                        BItemRecipeType.ENHANCED_CRAFTING_TABLE,
                        new ItemStack[] {
                                null, item(Material.ENDER_PEARL), null,
                                item(Material.ENDER_PEARL), null, item(Material.ENDER_PEARL),
                                null, item(Material.ENDER_PEARL), null
                        }
                )
        );
    }
}
