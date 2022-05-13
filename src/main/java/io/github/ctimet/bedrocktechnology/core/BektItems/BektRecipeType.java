package io.github.ctimet.bedrocktechnology.core.BektItems;

import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

public class BektRecipeType extends RecipeType {
    public BektRecipeType(NamespacedKey key, SlimefunItemStack slimefunItem, String... lore) {
        super(key, slimefunItem, null, lore);
    }

    public static final BektRecipeType BEKT_EYHGT;

    static {
        //二氧化硅提取器
        BEKT_EYHGT = new BektRecipeType(
                BektMain.createKey("BEKT_EYHGT"),
                BektItemStacks.BEKT_EYHGT,
                ""
        );
    }
}
