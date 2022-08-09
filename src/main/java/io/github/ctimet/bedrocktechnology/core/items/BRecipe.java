package io.github.ctimet.bedrocktechnology.core.items;

import org.bukkit.inventory.ItemStack;

public class BRecipe {
    int s;
    ItemStack o;
    public BRecipe(int seconds, ItemStack out) {
        this.s = seconds;
        this.o = out;
    }

    public int getSeconds() {
        return this.s;
    }

    public ItemStack getOut() {
        return this.o;
    }
}