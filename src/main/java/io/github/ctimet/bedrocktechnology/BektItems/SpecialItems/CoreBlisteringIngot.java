package io.github.ctimet.bedrocktechnology.BektItems.SpecialItems;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import org.bukkit.inventory.ItemStack;

/**
 * 一个有着特殊物品的类--起泡锭核心，其重写了getRadioactivity方法使其充满辐射
 * @author CTimet
 * @see io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
 * @see io.github.thebusybiscuit.slimefun4.core.attributes.ItemAttribute
 * @version beta1.0.0
 */
public class CoreBlisteringIngot extends SlimefunItem implements Radioactive
{
    public CoreBlisteringIngot(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public Radioactivity getRadioactivity() {
        return Radioactivity.HIGH;
    }
}
