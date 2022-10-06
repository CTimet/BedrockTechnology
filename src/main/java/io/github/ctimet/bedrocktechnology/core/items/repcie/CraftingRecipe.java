package io.github.ctimet.bedrocktechnology.core.items.repcie;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public record CraftingRecipe(ItemStack[] input, SlimefunItemStack output) {
    public boolean check(ItemStack[] other) {
        if (other.length != input.length)
            return false;
        for (int i = 0; i < input.length; i++) {
            if (!isItemSimilar(input[i], other[i])) {
                return false;
            }
        }
        return true;
    }

    public void consume(ItemStack[] in) {
        for (int i = 0; i < in.length; i ++) {
            if (in[i] != null) {
                in[i].setAmount(in[i].getAmount() - input[i].getAmount());
            }
        }
    }

    public boolean isItemSimilar(ItemStack item, ItemStack other) {
        if (other == null && item == null) return true;
        if (other == null || item == null) return false;
        return item.isSimilar(other) && item.getAmount() <= other.getAmount();
    }
}
