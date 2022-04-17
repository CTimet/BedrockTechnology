package io.github.ctimet.bedrocktechnology.core.BektItems.material.JcjqBasicMachine;

import io.github.ctimet.bedrocktechnology.abstractClass.BektAContainerTwoSlot;
import io.github.ctimet.bedrocktechnology.core.BektItems.BaseItem.BektItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Eyhgt extends BektAContainerTwoSlot
{

    /**
     * This creates a new {@link SlimefunItem} from the given arguments.
     *
     * @param itemGroup  The {@link ItemGroup} this {@link SlimefunItem} belongs to
     * @param item       The {@link SlimefunItemStack} that describes the visual features of our {@link SlimefunItem}
     * @param recipeType the {@link RecipeType} that determines how this {@link SlimefunItem} is crafted
     * @param recipe     An Array representing the recipe of this {@link SlimefunItem}
     */
    public Eyhgt(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    /**
     * 此方法返回{@link BektAContainerTwoSlot}用作进度条的{@link ItemStack}物品
     * <p>
     * 覆盖此方法可以设置进度条
     *
     * @return The {@link ItemStack} to use as the progress bar
     */
    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DIAMOND_HOE);
    }

    /**
     * 此方法返回用于标识此 BektAcontainerTwoSlot 及其配方的内部标识符。 在向 BektAcontainerTwoSlot 添加配方时，我们将使用此标识符来标识同一 BektAcontainerTwoSlot 的所有实例。 通过这种方式，我们可以将配方添加到同一台机器的所有实例中。 此方法将在未来被弃用和替换
     *
     * @return 机器标识
     */
    @Override
    public String getMachineIdentifier() {
        return "BEKT-EYHGT";
    }

    /**
     * 此方法注册此机器的所有默认配方。
     */
    @Override
    protected void registerDefaultRecipes() {
        this.registerRecipe(4,new ItemStack[]{new ItemStack(Material.SAND)},new ItemStack[]{BektItemStack.BEKT_EYHG});
    }
}
