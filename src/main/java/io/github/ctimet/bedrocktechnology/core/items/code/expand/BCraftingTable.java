package io.github.ctimet.bedrocktechnology.core.items.code.expand;

import io.github.ctimet.bedrocktechnology.core.items.repcie.CraftingRecipe;
import io.github.ctimet.bedrocktechnology.template.AbstractGui;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;

public class BCraftingTable extends AbstractGui {
    private static final int[] YELLOW = {
            0, 9, 18, 27, 36, 45
    };
    private static final int[] GREEN = {
            7, 8, 16, 25, 26
    };
    private static final int[] BLUE = {
            34, 35, 43, 52, 53
    };
    private static final int[] SLOTS = {
            1,  2,  3,  4,  5,  6,
            10, 11, 12, 13, 14, 15,
            19, 20, 21, 22, 23, 24,
            28, 29, 30, 31, 32, 33,
            37, 38, 39, 40, 41, 42,
            46, 47, 48, 49, 50, 51
    };

    private static final LinkedList<CraftingRecipe> RECIPES = new LinkedList<>();

    public BCraftingTable(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void createGui(BlockMenuPreset preset) {
        CustomItemStack yellow = new CustomItemStack(Material.YELLOW_STAINED_GLASS_PANE, "&7&o配方");
        CustomItemStack green = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "&7&o制作");
        CustomItemStack blue = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, "&7&o产物");
        for (int i : YELLOW) {
            preset.addItem(i, yellow, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : GREEN) {
            preset.addItem(i, green, ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : BLUE) {
            preset.addItem(i, blue, ChestMenuUtils.getEmptyClickHandler());
        }

        CustomItemStack table = new CustomItemStack(Material.CRAFTING_TABLE, "&b点击制作");
        preset.addItem(17, table, (p, clickSlot, item, action) -> {
            ItemStack[] input = new ItemStack[SLOTS.length];
            for (int i = 0; i < SLOTS.length; i ++) {
                input[i] = p.getOpenInventory().getItem(SLOTS[i]);
            }

            for (CraftingRecipe recipe : RECIPES) {
                if (recipe.check(input)) {
                    recipe.consume(input);
                    p.getOpenInventory().setItem(44, recipe.output());
                    return false;
                }
            }

            p.sendMessage(ChatColor.RED + "未找到此配方");

            return false;
        });
    }

    public static void registerRecipe(ItemStack[] input, SlimefunItemStack output) {
        RECIPES.add(new CraftingRecipe(input, output));
    }
}
