package io.github.ctimet.bedrocktechnology.core.items.repcie;

import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.util.Util;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

public class BRecipeType extends RecipeType {
    public static final BRecipeType BEKT_CRAFTING_TABLE = new BRecipeType(Util.createNamespacedKey("BEKT_CRAFTING_TABLE"), BItemStacks.BEKT_CRAFTING_TABLE);

    public BRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, lore);
    }
}
