package io.github.ctimet.bedrocktechnology.core.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BErrorItem {
    private static final SlimefunItemStack ERR_RECIPE = new SlimefunItemStack(
            "BEKT_ERR_RECIPE",
            Material.BARRIER,
            "&4配方显示错误",
            "&4由于物品配方过于强大，这个小小的指南书不能显示配方",
            "&4请转至\"物品配方查看器\"中查看该物品配方"
    );
    public static ItemStack[] getErrRecipe() {
        return new ItemStack[] {
                null, null, null,
                null, BErrorItem.ERR_RECIPE, null,
                null, null, null
        };
    }
}
