package io.github.ctimet.bekt.BektItems.SpecialRecipeType;

import io.github.ctimet.bekt.BektItems.BektItemStack;
import io.github.ctimet.bekt.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.recipes.MinecraftRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

public class BektRecipeType extends RecipeType {
    public static final RecipeType BEKT_JGHQQ;

    static {
        BEKT_JGHQQ = new BektRecipeType(
                BektMain.createKey("BEKT_JGHQQ"),
                BektItemStack.BEKT_JGHQQ,
                "",
                "&7获取结构"
        );
    }

    public BektRecipeType(ItemStack item, String machine) {
        super(item, machine);
    }

    public BektRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, lore);
    }

    public BektRecipeType(NamespacedKey key, ItemStack item, BiConsumer<ItemStack[], ItemStack> callback, String... lore) {
        super(key, item, callback, lore);
    }

    public BektRecipeType(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    public BektRecipeType(MinecraftRecipe<?> recipe) {
        super(recipe);
    }
}
