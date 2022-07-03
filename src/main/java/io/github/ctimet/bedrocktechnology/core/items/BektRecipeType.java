package io.github.ctimet.bedrocktechnology.core.items;

import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

public class BektRecipeType extends RecipeType {
    public BektRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, null, lore);
    }

    public static final BektRecipeType BEKT_CLOUD_TABLE = new BektRecipeType(
            BektMain.createKey("BEKT_CLOUD_TABLE"),
            BektItemStacks.BEKT_CLOUD_TABLE,
            "",
            "构建，组装您的CLOUD云中转站"
    );
}
