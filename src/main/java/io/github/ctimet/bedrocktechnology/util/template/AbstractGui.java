package io.github.ctimet.bedrocktechnology.util.template;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public abstract class AbstractGui extends SlimefunItem {
    public AbstractGui(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        createPreset(this, getInvTitle(), this::createGui);
    }

    protected abstract void createGui(BlockMenuPreset preset);

    private static void createPreset(SlimefunItem item, String title, Consumer<BlockMenuPreset> setup) {
        new BlockMenuPreset(item.getId(), title) {
            @Override
            public void init() {
                setup.accept(this);
            }

            @Override
            @ParametersAreNonnullByDefault
            public boolean canOpen(Block b, Player p) {
                if (p.hasPermission("slimefun.inventory.bypass")) {
                    return true;
                } else {
                    return item.canUse(p, false) && Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK);
                }
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                return new int[0];
            }
        };
    }

    //覆盖此方法以重定义GUI名称
    protected String getInvTitle() {
        return this.getItemName();
    }
}