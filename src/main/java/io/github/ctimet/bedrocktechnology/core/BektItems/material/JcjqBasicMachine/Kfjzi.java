package io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine;

import io.github.ctimet.bedrocktechnology.abstractClass.BektAcontainerTwoSlot;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class Kfjzi extends BektAcontainerTwoSlot
{
    private static final ArrayList<ItemStack> outputItems = new ArrayList<>();

    static {
        addAll(
                new SlimefunItemStack(SlimefunItems.IRON_DUST,2),
                new SlimefunItemStack(SlimefunItems.COPPER_DUST,2),
                new SlimefunItemStack(SlimefunItems.TIN_DUST,2),
                new SlimefunItemStack(SlimefunItems.SILVER_DUST,2),
                new SlimefunItemStack(SlimefunItems.LEAD_DUST,2),
                new SlimefunItemStack(SlimefunItems.ALUMINUM_DUST,2),
                new SlimefunItemStack(SlimefunItems.ZINC_DUST,2),
                new SlimefunItemStack(SlimefunItems.MAGNESIUM_DUST,2),
                new SlimefunItemStack(SlimefunItems.GOLD_DUST,2)
        );
    }

    public Kfjzi(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        //进度条
        return new ItemStack(Material.DIAMOND_PICKAXE);
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
        ItemStack[] input   = new ItemStack[]{
                new ItemStack(Material.COBBLESTONE,4)
        };
        ItemStack[] output  = new ItemStack[]{
                new ItemStack(SlimefunItems.IRON_DUST)
        };
        this.registerRecipe(3,input,output,outputItems,true);
    }

    public static void addAll(ItemStack... itemStacks){
        outputItems.addAll(Arrays.asList(itemStacks));
    }
}
