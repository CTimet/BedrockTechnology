package io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Kfjzi extends AContainer
{
    public Kfjzi(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        //进度条
        return new ItemStack(Material.STONE_AXE);
    }

    @Override
    public String getMachineIdentifier() {
        //机器标识
        return "BEKT-KFJZI";
    }

    /**
     * 注册配方
     */
    @Override
    public void registerDefaultRecipes(){
        ItemStack[] input   = new ItemStack[]{new ItemStack(Material.COBBLESTONE,4)};
        ItemStack[] output  = new ItemStack[]{SlimefunItems.IRON_DUST, SlimefunItems.COPPER_DUST, SlimefunItems.TIN_DUST, SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.LEAD_DUST, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ZINC_DUST, SlimefunItems.MAGNESIUM_DUST, SlimefunItems.GOLD_DUST};
        this.registerRecipe(3,input, output);
    }
}
