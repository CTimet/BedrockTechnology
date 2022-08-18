package io.github.ctimet.bedrocktechnology.data;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public record SpecialRecipe(String itemName, ItemStack[] recipe, ItemStack make, SlimefunItemStack out) {
}
