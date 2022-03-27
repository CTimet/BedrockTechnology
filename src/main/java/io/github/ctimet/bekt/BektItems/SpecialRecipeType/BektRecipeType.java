package io.github.ctimet.bekt.BektItems.SpecialRecipeType;

import io.github.ctimet.bekt.BektItems.BektItemStack;
import io.github.ctimet.bekt.BektMain;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.recipes.MinecraftRecipe;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

/**
 * 这是一个特殊的类，用于标记一些特殊物品的来源机器
 * @author CTimet
 * @see io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
 */
public class BektRecipeType extends RecipeType
{
    public static final RecipeType BEKT_JGHQQ;
    public static final RecipeType BEKT_LZTQI;

    static {
        //结构获取器
        BEKT_JGHQQ = new BektRecipeType(
                BektMain.createKey("BEKT_JGHQQ"),
                BektItemStack.BEKT_JGHQQ,
                "",
                "&7获取结构"
        );

        //粒子提取机
        BEKT_LZTQI = new BektRecipeType(
                BektMain.createKey("BEKT_LZTQI"),
                BektItemStack.BEKT_LZTQI,
                "",
                "轰击物品产出对应粒子"
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
