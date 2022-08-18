package io.github.ctimet.bedrocktechnology.core.items.network;

import io.github.ctimet.bedrocktechnology.core.items.BItemStacks;
import io.github.ctimet.bedrocktechnology.data.SpecialRecipe;
import io.github.ctimet.bedrocktechnology.network.BIP;
import io.github.ctimet.bedrocktechnology.template.OnlyGui;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.inventory.ItemStack;

public class Cloud extends OnlyGui implements BIP {
    public Cloud(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        ItemRecipeShow.addRecipe("Cloud云", new SpecialRecipe(item.getDisplayName(), new ItemStack[]{
            null, BItemStacks.BEKT_CLOUD,  null, BItemStacks.BEKT_CLOUD
        }, recipeType.toItem(), item));
    }

    @Override
    protected void createGui(BlockMenuPreset preset) {

    }
}
