package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

public class BItemRecipeType extends RecipeType {
    public static final RecipeType BEKT_CLOUD_TABLE = new BItemRecipeType(
            BektMain.createNamespacedKey("CLOUD_TABLE"),
            BItemStacks.BEKT_CLOUD_TABLE,
            "制作属于您的CLOUD云"
    );

    public BItemRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, lore);
    }
}
