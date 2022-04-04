package io.github.ctimet.bedrocktechnology.BektItems.SpecialRecipeType;

import io.github.ctimet.bedrocktechnology.BektItems.BektItemStack;
import io.github.ctimet.bedrocktechnology.BektMain;
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
    public static final RecipeType BEKT_JYHJQ;
    public static final RecipeType BEKT_WPLZT;
    public static final RecipeType BEKT_GQYJD;
    public static final RecipeType BEKT_GTQJQ;
    public static final RecipeType BEKT_GHJJQ;
    public static final RecipeType BEKT_DJLZZ;

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
                "产出基本粒子"
        );

        //基岩轰击器
        BEKT_JYHJQ = new BektRecipeType(
                BektMain.createKey("BEKT_JYHJQ"),
                BektItemStack.BEKT_JYHJQ,
                "",
                "轰击此区块内的基岩产出基岩粒子"
        );

        //物品粒子提取机
        BEKT_WPLZT = new BektRecipeType(
                BektMain.createKey("BEKT_WPLZT"),
                BektItemStack.BEKT_WPLZT,
                "",
                "提取某个锭的粒子（仅支持部分锭）"
        );

        //基岩对撞机
        BEKT_GQYJD = new BektRecipeType(
                BektMain.createKey("BEKT_GQYJD"),
                BektItemStack.BEKT_GQJYD,
                "",
                "从基岩粒子中分裂出更小的一部分——基岩夸克"
        );

        //汞提取机
        BEKT_GTQJQ = new BektRecipeType(
                BektMain.createKey("BEKT_GTQJQ"),
                BektItemStack.BEKT_GTQJQ,
                "",
                "从自然界中提取汞，小心！汞有毒"
        );

        //汞轰击器
        BEKT_GHJJQ = new BektRecipeType(
                BektMain.createKey("BEKT_GHJJQ"),
                BektItemStack.BEKT_GHJJQ,
                "",
                "&7&o通过轰击汞来产生超级纯的金子！虽然...这很耗电"
        );

        //低级粒子对撞机
        BEKT_DJLZZ = new BektRecipeType(
                BektMain.createKey("BEKT_DJLZZ"),
                BektItemStack.BEKT_DJLZZ,
                "",
                "分裂粒子产出夸克"
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
